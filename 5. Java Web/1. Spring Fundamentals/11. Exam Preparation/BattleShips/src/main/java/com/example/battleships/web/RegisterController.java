package com.example.battleships.web;

import com.example.battleships.model.DTO.RegisterDTO;
import com.example.battleships.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class RegisterController {

    private final HttpSession httpSession;
    private final UserService userService;

    public RegisterController(HttpSession httpSession, UserService userService) {
        this.httpSession = httpSession;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {

        if (this.httpSession.getAttribute("name") != null) {
            return "home";
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid RegisterDTO registerDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.userService.registerUser(registerDTO)) {
            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", bindingResult);
            return "redirect:/users/register";
        }
        return "redirect:/users/login";
    }

    @ModelAttribute("registerDTO")
    private RegisterDTO initForm() {
        return new RegisterDTO();
    }

}
