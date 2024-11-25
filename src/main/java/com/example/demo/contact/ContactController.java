package com.example.demo.contact;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/v1/contact")
public class ContactController {
    @GetMapping("main")
    public String openmain(Model md) {
        List<Contact> lc=ContactService.show();
        md.addAttribute("contact", lc);
        return "main";
    }
    @GetMapping("addcontact")
    public String addcontact(Model md) {
        Contact contact=new Contact();
        md.addAttribute("contact", contact);
        return "addContact";
    }
    @PostMapping("addcontact")
    public String showadd(@Valid Contact contact, BindingResult res, Model md) {
        if(res.hasErrors()) {
            return "addContact";
        }
        ContactService.AddContact(contact);
        md.addAttribute("contact", ContactService.show());
        return "redirect:main";
    }

}
