package com.example.irrigation.web;

import com.example.irrigation.model.DTO.UserLoginDTO;
import com.example.irrigation.model.DTO.UserRegisterDTO;
import com.example.irrigation.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    private String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                errorMessage = ex.getMessage();
            }
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }


    @GetMapping("/register")
    private String register(Model model) {

        if (!model.containsAttribute("userRegisterDTO")) {
            model.addAttribute("userRegisterDTO", new UserRegisterDTO());
            model.addAttribute("isExisting", false);
//            return "redirect:/";
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
        return "redirect:/";
    }

}
