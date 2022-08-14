package com.example.irrigation2.web;

import com.example.irrigation2.model.DTO.AddSprinklerDTO;
import com.example.irrigation2.service.SprinklerService;
import org.aspectj.bridge.MessageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.lang.annotation.Repeatable;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final SprinklerService sprinklerService;

    public AdminController(SprinklerService sprinklerService) {
        this.sprinklerService = sprinklerService;
    }

    @GetMapping()
    public String admin(){
        return "admin";
    }

    @GetMapping("/sprinklers")
    public String sprinklers(Model model){
        if (!model.containsAttribute("addSprinklerDTO")) {
            model.addAttribute("addSprinklerDTO", new AddSprinklerDTO());
            model.addAttribute("isExisting", false);
        }
        return "add-sprinklers";
    }

    @PostMapping("/sprinklers")
    public String addSprinklers(@Valid AddSprinklerDTO addSprinklerDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,@RequestParam("image") MultipartFile multipartFile){

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
    public String pumps(Model model){
        if (!model.containsAttribute("addSprinklerDTO")) {
            model.addAttribute("addSprinklerDTO", new AddSprinklerDTO());
            model.addAttribute("isExisting", false);
        }
        return "add-sprinklers";
    }

    @PostMapping("/pumps")
    public String addPumps(@Valid AddSprinklerDTO addSprinklerDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addSprinklerDTO", addSprinklerDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addSprinklerDTO", bindingResult);
            return "redirect:/admin/sprinklers";
        }
        sprinklerService.addSprinklerToDB(addSprinklerDTO);
        return "redirect:/admin";
    }
}
