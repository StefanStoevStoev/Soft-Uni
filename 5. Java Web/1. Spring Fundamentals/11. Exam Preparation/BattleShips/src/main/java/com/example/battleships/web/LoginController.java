package com.example.battleships.web;

import com.example.battleships.model.DTO.LoginDTO;
import com.example.battleships.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class LoginController {

    private final UserService userService;
    private final HttpSession httpSession;

    public LoginController(UserService userService, HttpSession httpSession) {
        this.userService = userService;
        this.httpSession = httpSession;
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (this.httpSession.getAttribute("name") != null) {
            return "home";
        }
        if (!model.containsAttribute("isFound")) {
            model.addAttribute("isFound", true);
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginDTO loginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", bindingResult);
            return "redirect:login";
        }

        if (!userService.loginUser(loginDTO)) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("isFound", false);
            return "redirect:login";
        }
        return "redirect:/home";
    }

    @ModelAttribute("loginDTO")
    public LoginDTO initForm() {
        return new LoginDTO();
    }
}
