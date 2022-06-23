package com.example.battleships.web;

import com.example.battleships.model.DTO.ShipDTO;
import com.example.battleships.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/add")
    public String addShips() {
        return "ship-add";
    }

    @PostMapping("/add")
    public String addShips(@Valid ShipDTO shipDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !shipService.registrationShip(shipDTO)) {
            redirectAttributes.addFlashAttribute("shipDTO", shipDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipDTO", bindingResult);
            return "redirect:/ships/add";
        }

        return "redirect:/home";
    }

    @ModelAttribute("shipDTO")
    private ShipDTO initForm(){
        return new ShipDTO();
    }
}
