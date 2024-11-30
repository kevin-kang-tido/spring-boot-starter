package com.example.demo.contact;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/contact")
public class ContactController {

    private final ContactService contactService;

    @GetMapping("main")
    public String openMain(Model md) {
        List<Contact> contactList = contactService.show(); // Use injected service
        md.addAttribute("contact", contactList);
        return "main"; // Returns main.html
    }

    @GetMapping("addcontact")
    public String addContact(Model md) {
        Contact contact = new Contact();
        md.addAttribute("contact", contact);
        return "addContact";
    }

    @PostMapping("addcontact")
    public String showAdd(@Valid @ModelAttribute Contact contact, BindingResult res, Model md) {
        if (res.hasErrors()) {
            return "addContact";
        }
        contactService.AddContact(contact); 
        return "redirect:/api/v1/contact/main"; 
    }

    @GetMapping("delete/{id}")
    public String deleteContact(@PathVariable("id") int id) {

        contactService.deleteContact(id); 

        return "redirect:/api/v1/contact/main"; 
    }

    @GetMapping("show/{id}")
    public String showUpdate(Model md, @PathVariable("id") int id) {
        Contact c = contactService.findContact(id); // Use the service to fetch the contact
        md.addAttribute("contact", c);
        return "UpdateContact"; // Ensure this matches the name of your Thymeleaf template
    }
    

    @PostMapping("update")
    public String updateContact(@RequestParam int id, @Valid @ModelAttribute Contact contact, BindingResult res, Model md) {
        if (res.hasErrors()) {
            return "updateContact";
        }
        contactService.updateContact(id, contact); 
        return "redirect:/api/v1/contact/main"; 
}
}
