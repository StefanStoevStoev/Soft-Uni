package com.example.irrigation.web;

import com.example.irrigation.model.DTO.UserLoginDTO;
import com.example.irrigation.model.DTO.UserRegisterDTO;
import com.example.irrigation.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("currentUser")
    public UserDetails getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : (UserDetails) authentication.getPrincipal();
    }

    @GetMapping("/login")
    private String login(Model model) {
        if(!model.containsAttribute("userLoginDTO")){
            model.addAttribute("userLoginDTO", new UserLoginDTO());
            model.addAttribute("isExisting", false);
        }
        return "login";
    }

    @PostMapping("/login-error")
    public String onFiledLogin(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                               String username,
                               @Valid UserLoginDTO userLoginDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO", bindingResult);
            redirectAttributes.addFlashAttribute("notFound", true);
            redirectAttributes.addFlashAttribute("username", username);
//                    .addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username)
//                    .addFlashAttribute("notFound", true);
        }

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
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userService.registerAndLogin(userRegisterDTO)) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
//            if (!userService.registerAndLogin(userRegisterDTO)) {
//            }
            return "redirect:register";
        }
        return "redirect:/index";
    }

}
