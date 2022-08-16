package com.example.irrigation2.web;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.model.DTO.SprinklerDTO;
import com.example.irrigation2.model.entity.SprinklerEntity;
import com.example.irrigation2.service.SprinklerService;
import com.example.irrigation2.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class SprinklersController {

    private final SprinklerService sprinklerService;
    private final UserService userService;

    public SprinklersController(SprinklerService sprinklerService,
                                UserService userService) {
        this.sprinklerService = sprinklerService;
        this.userService = userService;
    }

    @GetMapping("/sprinkler")
    public String sprinklerPage(Model model,
                                @AuthenticationPrincipal CurrentUserDetails currentUser) {

        if (!model.containsAttribute("sprinklerDTO")) {
            model.addAttribute("sprinklerDTO", new SprinklerDTO());
        }

        if (!model.containsAttribute("getSprinklers")) {
            List<SprinklerEntity> allSprinklers = this.sprinklerService.getAllSprinklers();
            model.addAttribute("getSprinklers", allSprinklers);
        }
        if (currentUser != null) {
            model.addAttribute("getUserId", currentUser.getId());
        }
        return "products-sprinkler";
    }

    @PostMapping("/sprinkler")
    public String saveDripDetails(SprinklerDTO sprinklerDTO,
                                  @AuthenticationPrincipal CurrentUserDetails currentUser) {
        sprinklerService.addSprinklerToUser(sprinklerDTO, currentUser);
        return "redirect:/auth-home/" + currentUser.getId();
    }
}