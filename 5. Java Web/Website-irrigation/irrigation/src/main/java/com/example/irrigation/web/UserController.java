package com.example.irrigation.web;

import com.example.irrigation.model.DTO.UserLoginDTO;
import com.example.irrigation.model.DTO.UserRegisterDTO;
import com.example.irrigation.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Collection;

import static com.example.irrigation.web.errors.GlobalErrors.INVALID_PASSWORD;
import static com.example.irrigation.web.errors.GlobalErrors.INVALID_USERNAME_MESSAGE;
import static org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY;
import static org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final LocaleResolver localeResolver;

    public UserController(UserService userService, LocaleResolver localeResolver) {
        this.userService = userService;

        this.localeResolver = localeResolver;
    }

    @ModelAttribute("currentUser")
    public UserDetails getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : (UserDetails) authentication.getPrincipal();
    }

    @GetMapping("/login")
    private String login(Model model) {
        if (!model.containsAttribute("userLoginDTO")) {
            model.addAttribute("userLoginDTO", new UserLoginDTO());
            model.addAttribute("isExisting", false);
        }
        return "login";
    }

    @PostMapping("/login-error")
    public String loginError(@ModelAttribute(SPRING_SECURITY_FORM_USERNAME_KEY)
                             String username,
                             @ModelAttribute(SPRING_SECURITY_FORM_PASSWORD_KEY)
                             String password,
                             @Valid UserLoginDTO userLoginDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("bad_credentials", true);

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO", bindingResult);
            redirectAttributes.addFlashAttribute("notFound", true);
            redirectAttributes.addFlashAttribute("username", username);
        }

        Collection<String> errorMessages = new ArrayList<>();
        if (this.userService.exists(username)) {
            if (!this.userService.isPasswordValid(username, password)) {
                errorMessages.add(INVALID_PASSWORD);
            }
        } else {
            String errorMessage = String.format(INVALID_USERNAME_MESSAGE, username);
            errorMessages.add(errorMessage);
        }

        redirectAttributes.addFlashAttribute("errors", errorMessages);

        return "redirect:/users/login";
    }

    @GetMapping("/register")
    private String register(Model model) {

        if (!model.containsAttribute("userRegisterDTO")) {
            model.addAttribute("userRegisterDTO", new UserRegisterDTO());
            model.addAttribute("isExisting", false);
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userRegisterDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           HttpServletRequest request) {


        boolean registerAndLogin = userService.registerAndLogin(userRegisterDTO, localeResolver.resolveLocale(request));
        if (bindingResult.hasErrors() || !registerAndLogin) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
            return "redirect:register";
        }
        return "redirect:/index";
    }
}
