package com.example.irrigation.web;

import com.example.irrigation.service.DripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class DripsController {

    private final DripService dripService;

    public DripsController(DripService dripService) {
        this.dripService = dripService;
    }


    @GetMapping("/drip")
    public String getDrip(Model model) {

        if (!model.containsAttribute("getDripById1")) {
            model.addAttribute("getDripById1", this.dripService.getDripById(1L));
        }
        if (!model.containsAttribute("getDripById2")) {
            model.addAttribute("getDripById2", this.dripService.getDripById(2L));
        }
        if (!model.containsAttribute("getDripById3")) {
            model.addAttribute("getDripById3", this.dripService.getDripById(3L));
        }
        if (!model.containsAttribute("getDripById4")) {
            model.addAttribute("getDripById4", this.dripService.getDripById(4L));
        }

        return "products-drip";
    }
}
