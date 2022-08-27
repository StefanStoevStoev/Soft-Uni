package com.example.irrigation2.web;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.model.DTO.AuthDTO;

import com.example.irrigation2.model.entity.DripEntity;
import com.example.irrigation2.model.entity.PumpEntity;
import com.example.irrigation2.model.entity.SprinklerEntity;
import com.example.irrigation2.model.views.UserViewModel;
import com.example.irrigation2.service.DripService;
import com.example.irrigation2.service.PumpService;
import com.example.irrigation2.service.SprinklerService;
import com.example.irrigation2.service.UserService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthController {

    private final UserService userService;
    private final DripService dripService;
    private final SprinklerService sprinklerService;
    private final PumpService pumpService;

    public AuthController(UserService userService, DripService dripService, SprinklerService sprinklerService, PumpService pumpService) {
        this.userService = userService;
        this.dripService = dripService;
        this.sprinklerService = sprinklerService;
        this.pumpService = pumpService;
    }

    @GetMapping("/")
    public String getById(Model model,
                          @AuthenticationPrincipal CurrentUserDetails currentUser) {
        if (!model.containsAttribute("getUserId") && currentUser != null){
            model.addAttribute("getUserId", currentUser.getId());
        }
        return "index";
    }

    @GetMapping("/auth-home/{id}")
    public String getById(@PathVariable("id") Long id, Model model,
                          @AuthenticationPrincipal CurrentUserDetails currentUser) {
        List<DripEntity> dripNumsByUser = dripService.getDripNumsByUser(id);
        List<SprinklerEntity> sprinklerNumsByUser = sprinklerService.getSprinklerNumsByUser(id);
        List<PumpEntity> pumpNumsByUser = pumpService.getPumpNumsByUser(id);

        model.addAttribute("dripNumsByUser", dripNumsByUser);
        model.addAttribute("sprinklerNumsByUser", sprinklerNumsByUser);
        model.addAttribute("pumpNumsByUser", pumpNumsByUser);

        if(currentUser == null){
            return "login";
        }
        UserViewModel user = userService.getUserById(currentUser.getId());
        model.addAttribute("userDetails", user);
        model.addAttribute("getUserId", currentUser.getId());

        return "auth-home";
    }

    @PostMapping("/auth-home")
    public String addUser(@Valid AuthDTO authDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,
                          @AuthenticationPrincipal CurrentUserDetails currentUser) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("authDTO", authDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.authDTO", bindingResult);
            return "redirect:/auth-home/" + currentUser.getId();
        }
        redirectAttributes.addFlashAttribute("uId", currentUser.getId());
        userService.saveDataToUser(authDTO, currentUser);
        return "redirect:/auth-home/" + currentUser.getId();
    }

    @ModelAttribute("userViewModel")
    private UserViewModel addModel() {
        return new UserViewModel();
    }

    @ModelAttribute("authDTO")
    private AuthDTO addModelAuth() {
        return new AuthDTO();
    }
}
