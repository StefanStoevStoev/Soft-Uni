package com.example.irrigation2.web;

import com.example.irrigation2.service.PumpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class PumpsController {

    private final PumpService pumpService;

    public PumpsController(PumpService pumpService) {
        this.pumpService = pumpService;
    }

    @GetMapping("/pump")
    public String pumpsLoad(Model model) throws Exception {

        if (!model.containsAttribute("hiPeri1_5")) {
            model.addAttribute("hiPeri1_5", pumpService.getPumpById(1L));
        }
        if (!model.containsAttribute("pf_1_30")) {
            model.addAttribute("pf_1_30", pumpService.getPumpById(2L));
        }
        return "products-pump";
    }
}
