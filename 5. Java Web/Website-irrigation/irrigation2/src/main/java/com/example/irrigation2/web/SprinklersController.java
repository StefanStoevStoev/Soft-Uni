package com.example.irrigation2.web;

import com.example.irrigation2.service.SprinklerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class SprinklersController {

    private final SprinklerService sprinklerService;

    public SprinklersController(SprinklerService sprinklerService) {
        this.sprinklerService = sprinklerService;
    }

    @GetMapping("/sprinkler")
    public String sprinklerPage(Model model) {

        if (!model.containsAttribute("getSprinklerById1")) {
            model.addAttribute("getSprinklerById1", sprinklerService.getSprinklerById(1L));
        }
        if (!model.containsAttribute("getSprinklerById2")) {
            model.addAttribute("getSprinklerById2", sprinklerService.getSprinklerById(2L));
        }
        if (!model.containsAttribute("getSprinklerById3")) {
            model.addAttribute("getSprinklerById3", sprinklerService.getSprinklerById(3L));
        }
        if (!model.containsAttribute("getSprinklerById4")) {
            model.addAttribute("getSprinklerById4", sprinklerService.getSprinklerById(4L));
        }
        if (!model.containsAttribute("getSprinklerById5")) {
            model.addAttribute("getSprinklerById5", sprinklerService.getSprinklerById(5L));
        }
        if (!model.containsAttribute("getSprinklerById6")) {
            model.addAttribute("getSprinklerById6", sprinklerService.getSprinklerById(6L));
        }
        return "products-sprinkler";
    }
}
