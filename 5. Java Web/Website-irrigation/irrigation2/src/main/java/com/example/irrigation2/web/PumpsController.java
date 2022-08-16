package com.example.irrigation2.web;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.model.DTO.PumpDTO;
import com.example.irrigation2.model.entity.PumpEntity;
import com.example.irrigation2.service.PumpService;
import com.example.irrigation2.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class PumpsController {

    private final PumpService pumpService;
    private final UserService userService;

    public PumpsController(PumpService pumpService, UserService userService) {
        this.pumpService = pumpService;
        this.userService = userService;
    }

    @GetMapping("/pump")
    public String pumpsLoad(Model model,
                            @AuthenticationPrincipal CurrentUserDetails currentUser) {

        if (!model.containsAttribute("PumpDTO")) {
            model.addAttribute("PumpDTO", new PumpDTO());
        }
        if (!model.containsAttribute("getPumps")) {
            List<PumpEntity> allPumps = this.pumpService.getAllPumps();
            model.addAttribute("getPumps", allPumps);
        }
        if (currentUser != null) {
            model.addAttribute("getUserId", currentUser.getId());
        }
        return "products-pump";
    }

    @PostMapping("/pump")
    public String sprinklerAddPage( PumpDTO pumpDTO,
                                   @AuthenticationPrincipal CurrentUserDetails currentUser) {
        pumpService.addPumpToUser(pumpDTO, currentUser);
        return "redirect:/auth-home/" + currentUser.getId();
    }
}
