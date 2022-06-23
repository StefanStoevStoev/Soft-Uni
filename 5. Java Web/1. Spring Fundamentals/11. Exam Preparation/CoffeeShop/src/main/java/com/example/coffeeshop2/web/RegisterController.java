package com.example.coffeeshop2.web;

import com.example.coffeeshop2.model.entity.DTO.UserRegisterDTO;
import com.example.coffeeshop2.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegisterController {

    private final HttpSession httpSession;
    private final UserService userService;


    public RegisterController(HttpSession httpSession,
                              UserService userService) {
        this.httpSession = httpSession;
        this.userService = userService;
    }

    @ModelAttribute("userRegisterDTO")
    public UserRegisterDTO initForm() {
        return new UserRegisterDTO();
    }

    @GetMapping("/register")
    public String register() {

        System.out.println(httpSession.getAttribute("user"));

        if (this.httpSession.getAttribute("user") != null) {
            return "redirect:/home";
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userRegisterDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !this.userService.registerUser(userRegisterDTO)) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.
                    addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
            return "redirect:register";
        }
        return "redirect:login";
    }
}
