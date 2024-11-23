package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SpringTesting {

    private  CheckUser checkUser = new CheckUser();

    @GetMapping("/greet")
    public String getMethod(Model model,
                            @RequestParam(name = "name",defaultValue = "kevinntido") String data)
//                            @PathVariable(name = "name")String data)
    {
        model.addAttribute("name",data);

        return"index";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String main(Model model,@RequestParam String uname,
                       @RequestParam String pwd){

        List<Appointment> apm= AppointmentService.FindUser(uname);
        model.addAttribute("ap", apm);

        if (checkUser.isUser(uname,pwd)){
            model.addAttribute("name",uname);
            model.addAttribute("uname",uname);
            return "main";
        }
        model.addAttribute("error","Invalid Username or Password");
        return "login";
    }


    
}
