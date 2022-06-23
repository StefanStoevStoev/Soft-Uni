package com.example.coffeeshop2.web;

import com.example.coffeeshop2.model.entity.DTO.UserLoginDTO;
import com.example.coffeeshop2.seasson.CurrentUser;
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
//@RequestMapping("/user")
public class LoginController {

    private final UserService userService;
    private final CurrentUser currentUser;

    public LoginController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
    }

//    @ModelAttribute
//    private

    @ModelAttribute("userLoginDTO")
    private UserLoginDTO initForm() {
        return new UserLoginDTO();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginDTO userLoginDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.
                    addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO", bindingResult);
            return "redirect:/login";
        }

        if (!this.userService.loginUser(userLoginDTO)){
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);
            return "redirect:/login";
        }

        return "redirect:/home";
    }
    @GetMapping("logout")
    public String logout(){
        this.currentUser.logout();
        return "redirect:/";
    }
}
