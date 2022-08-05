package com.example.irrigation2.web;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.model.DTO.AuthDTO;

import com.example.irrigation2.model.views.UserViewModel;
import com.example.irrigation2.service.DripService;
import com.example.irrigation2.service.UserService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {

    private final UserService userService;
    private final DripService dripService;

    public AuthController(UserService userService, DripService dripService) {
        this.userService = userService;
        this.dripService = dripService;
    }

    @GetMapping("/auth-home/{id}")
    public String getById(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal UserDetails currentUser) {
        UserViewModel user = userService.getUserById(id);
        model.addAttribute("userDetails", user);

        return "auth-home";
    }

    @PostMapping("/auth-home")
    public String addUser( @Valid AuthDTO authDTO,
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

    //    @GetMapping("/drip/buy")
//    public String buyDrip(){
//        return "buy-drip";
//    }
//
//    @PostMapping("/drip/buy")
//    public String register(@Valid UserPhoneAndAddressDTO userPhoneAndAddressDTO,
//                           BindingResult bindingResult,
//                           RedirectAttributes redirectAttributes,
//                           @AuthenticationPrincipal CurrentUserDetails currentUser) {
//
////        Long id = currentUser.getId();
//        dripService.savePhoneAndAddress(userPhoneAndAddressDTO, currentUser);
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("userPhoneAndAddressDTO", userPhoneAndAddressDTO);
//            redirectAttributes.addFlashAttribute(
//                    "org.springframework.validation.BindingResult.userPhoneAndAddressDTO", bindingResult);
//            return "redirect:/products/drip/buy";
//        }
//
//        return "redirect:/products/drip/buy";
//    }
//
//    @ModelAttribute("userPhoneAndAddressDTO")
//    public UserPhoneAndAddressDTO initUserModel() {
//        return new UserPhoneAndAddressDTO();
//    }
//
    @ModelAttribute("userViewModel")
    private UserViewModel addModel() {
        return new UserViewModel();
    }

    @ModelAttribute("authDTO")
    private AuthDTO addModelAuth() {
        return new AuthDTO();
    }
}
