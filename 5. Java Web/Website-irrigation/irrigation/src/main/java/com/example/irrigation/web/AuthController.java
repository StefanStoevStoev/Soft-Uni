package com.example.irrigation.web;

import com.example.irrigation.model.CurrentUserDetails;
import com.example.irrigation.model.DTO.UserPhoneAndAddressDTO;
import com.example.irrigation.model.DTO.UserRegisterDTO;
import com.example.irrigation.model.views.UserViewModel;
import com.example.irrigation.service.DripService;
import com.example.irrigation.service.UserService;
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

@Controller
public class AuthController {

    private final UserService userService;
    private final DripService dripService;

    public AuthController(UserService userService, DripService dripService) {
        this.userService = userService;
        this.dripService = dripService;
    }

    //    @GetMapping("/auth-home/{id}")
//    public String userHome(@PathVariable String id){
//        return "auth-home";
//    }
    @GetMapping("/auth-home")
    public String getUser(@AuthenticationPrincipal CurrentUserDetails currentUser, Model model) {
        UserViewModel user = userService.getUserById(currentUser.getId());
        model.addAttribute("userDetails", user);
        return "auth-home";
    }
//
//    @PostMapping("/auth-home")
//    public String addUser(@Valid UserViewModel userViewModel,
//                          BindingResult bindingResult,
//                          RedirectAttributes redirectAttributes,
//                          Model model) {
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("userViewModel", userViewModel);
//            redirectAttributes.addFlashAttribute(
//                    "org.springframework.validation.BindingResult.userViewModel", bindingResult);
//            return "redirect:/products/auth-home";
//        }
//        model.addAttribute(userViewModel);
//        return "redirect:/";
//    }

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
}
