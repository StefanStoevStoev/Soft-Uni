package com.example.irrigation.web;

import com.example.irrigation.model.CurrentUserDetails;
import com.example.irrigation.model.DTO.UserPhoneAndAddressDTO;
import com.example.irrigation.service.DripService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class DripsController {

    private final DripService dripService;

    public DripsController(DripService dripService) {
        this.dripService = dripService;
    }


    @GetMapping("/drip")
    public String getDrip(Model model,@AuthenticationPrincipal CurrentUserDetails currentUser) {
        if (!model.containsAttribute("getDrips")) {
            model.addAttribute("getDrips", this.dripService.getAllDrips());
        }
        if (!model.containsAttribute("getDripById1")) {
            model.addAttribute("getDripById1", this.dripService.getDripByUserId(1L));
        }
        if (!model.containsAttribute("getDripById2")) {
            model.addAttribute("getDripById2", this.dripService.getDripByUserId(2L));
        }
        if (!model.containsAttribute("getDripById3")) {
            model.addAttribute("getDripById3", this.dripService.getDripByUserId(3L));
        }
        if (!model.containsAttribute("getDripById4")) {
            model.addAttribute("getDripById4", this.dripService.getDripByUserId(4L));
        }
        if(currentUser != null){
            model.addAttribute("userId", currentUser.getId());
        }

        return "products-drip";
    }

    @GetMapping("/drip/buy")
    public String buyDrip() {
        return "buy-drip";
    }

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
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userPhoneAndAddressDTO", bindingResult);
//            return "redirect:/products/drip/buy";
//        }
//
//        return "redirect:/auth-home";
//    }

    @ModelAttribute("userPhoneAndAddressDTO")
    public UserPhoneAndAddressDTO initUserModel() {
        return new UserPhoneAndAddressDTO();
    }
}