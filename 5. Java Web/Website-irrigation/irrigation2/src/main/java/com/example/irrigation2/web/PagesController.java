package com.example.irrigation2.web;

import com.example.irrigation2.model.CurrentUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class PagesController {

    @GetMapping("/all")
    public String all(){
        return "all";
    }

    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal CurrentUserDetails currentUser){
        if (!model.containsAttribute("getUserId") && currentUser != null){
            model.addAttribute("getUserId", currentUser.getId());
        }
        return "home";
    }

}
