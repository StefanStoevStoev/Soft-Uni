package com.example.irrigation2.web;

import com.example.irrigation2.model.DTO.AddDripDTO;
import com.example.irrigation2.model.DTO.AddPumpDTO;
import com.example.irrigation2.model.DTO.AddSprinklerDTO;
import com.example.irrigation2.service.DripService;
import com.example.irrigation2.service.PumpService;
import com.example.irrigation2.service.SprinklerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final SprinklerService sprinklerService;
    private final PumpService pumpService;
    private final DripService dripService;

    public AdminController(SprinklerService sprinklerService, PumpService pumpService, DripService dripService) {
        this.sprinklerService = sprinklerService;
        this.pumpService = pumpService;
        this.dripService = dripService;
    }

    @GetMapping()
    public String admin() {
        return "admin";
    }

    @GetMapping("/sprinklers")
    public String sprinklers(Model model) {
        if (!model.containsAttribute("addSprinklerDTO")) {
            model.addAttribute("addSprinklerDTO", new AddSprinklerDTO());
            model.addAttribute("isExisting", false);
        }
        return "add-sprinklers";
    }

    @PostMapping("/sprinklers")
    public String addSprinklers(@Valid AddSprinklerDTO addSprinklerDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addSprinklerDTO", addSprinklerDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addSprinklerDTO", bindingResult);
            return "redirect:/admin/sprinklers";
        }
        sprinklerService.addSprinklerToDB(addSprinklerDTO);

        return "redirect:/admin";
    }

    @GetMapping("/pumps")
    public String pumps(Model model) {
        if (!model.containsAttribute("addPumpDTO")) {
            model.addAttribute("addPumpDTO", new AddPumpDTO());
            model.addAttribute("isExisting", false);
        }
        return "add-pumps";
    }

    @PostMapping("/pumps")
    public String addPumps(@Valid AddPumpDTO addPumpDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addPumpDTO", addPumpDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addPumpDTO", bindingResult);
            return "redirect:/admin/pumps";
        }
        pumpService.addPumpToDB(addPumpDTO);
        return "redirect:/admin";
    }

    @GetMapping("/drips")
    public String drips(Model model) {
        if (!model.containsAttribute("addDripDTO")) {
            model.addAttribute("addDripDTO", new AddDripDTO());
            model.addAttribute("isExisting", false);
        }
        return "add-drips";
    }

    @PostMapping("/drips")
    public String addDrips(@Valid AddDripDTO addDripDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addDripDTO", addDripDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addDripDTO", bindingResult);
            return "redirect:/admin/drips";
        }
        dripService.addDripToDB(addDripDTO);
        return "redirect:/admin";
    }
}
