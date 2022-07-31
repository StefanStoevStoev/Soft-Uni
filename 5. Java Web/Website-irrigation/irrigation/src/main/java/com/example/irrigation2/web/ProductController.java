package com.example.irrigation2.web;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.service.DripService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private final DripService dripService;

    public ProductController(DripService dripService) {
        this.dripService = dripService;
    }

    @GetMapping("/auth-home/")
    public String getProduct(@AuthenticationPrincipal CurrentUserDetails currentUser,
                             Model model){
        dripService.getDripByUserId(currentUser.getId());
        return "auth-home";
    }
}
