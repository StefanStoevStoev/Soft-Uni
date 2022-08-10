package com.example.irrigation2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class PagesController {

    @GetMapping("/all")
    public String all(){
        return "all";
    }

    @GetMapping("/admin")
    public String admins(){
        return "admin";
    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
