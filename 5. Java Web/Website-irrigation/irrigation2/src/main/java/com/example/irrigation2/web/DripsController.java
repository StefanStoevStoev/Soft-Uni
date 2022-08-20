package com.example.irrigation2.web;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.model.DTO.DripDTO;
import com.example.irrigation2.model.entity.DripEntity;
import com.example.irrigation2.service.DripService;
import com.example.irrigation2.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class DripsController {

    private final DripService dripService;

    public DripsController(DripService dripService) {
        this.dripService = dripService;
    }

    @GetMapping("/drip")
    public String getDrip(Model model,
                          @AuthenticationPrincipal CurrentUserDetails currentUser) {

        if (!model.containsAttribute("dripDTO")) {
            model.addAttribute("dripDTO", new DripDTO());
        }
        if (!model.containsAttribute("getDrips")) {
            List<DripEntity> allDrips = this.dripService.getAllDrips();
            model.addAttribute("getDrips", allDrips);
        }
        if (currentUser != null) {
            model.addAttribute("getUserId", currentUser.getId());
        }
        return "products-drip";
    }

    @PostMapping("/drip")
    public String saveDripToUser(DripDTO dripDTO,
                                  @AuthenticationPrincipal CurrentUserDetails currentUser) {
        dripService.addDripToUser(dripDTO, currentUser);
        return "redirect:/auth-home/" + currentUser.getId();
    }
}