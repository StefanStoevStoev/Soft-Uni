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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class DripsController {

    private final DripService dripService;
    private final UserService userService;

    public DripsController(DripService dripService, UserService userService) {
        this.dripService = dripService;
        this.userService = userService;
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
    public String saveDripDetails(DripDTO dripDTO,
                                  @AuthenticationPrincipal CurrentUserDetails currentUser) {

        dripService.addDripToUser(dripDTO, currentUser);

        return "redirect:/auth-home/" + currentUser.getId();
    }

    @ModelAttribute("dripDTO")
    public DripDTO initDripModel() {
        return new DripDTO();
    }

    @ModelAttribute("currentUser")
    public UserDetails getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : (UserDetails) authentication.getPrincipal();
    }

}