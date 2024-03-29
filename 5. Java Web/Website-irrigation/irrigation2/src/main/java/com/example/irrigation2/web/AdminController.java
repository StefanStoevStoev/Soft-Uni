package com.example.irrigation2.web;

import com.example.irrigation2.model.DTO.*;
import com.example.irrigation2.model.entity.UserEntity;
import com.example.irrigation2.model.views.AuthViewModel;
import com.example.irrigation2.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final SprinklerService sprinklerService;
    private final PumpService pumpService;
    private final DripService dripService;
    private final UserService userService;
    private final AdminService adminService;

    public AdminController(SprinklerService sprinklerService, PumpService pumpService, DripService dripService, UserService userService, AdminService adminService) {
        this.sprinklerService = sprinklerService;
        this.pumpService = pumpService;
        this.dripService = dripService;
        this.userService = userService;
        this.adminService = adminService;
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

    @GetMapping("/users")
    public String users(Model model) {

        List<UserEntity> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "user";
    }

    @GetMapping()
    public String getOrders(Model model) {

        if (!model.containsAttribute("notSendSprinklers")) {
            List<AuthViewModel> notSendSprinklers = adminService.getNotSendSprinklers();
            model.addAttribute("notSendSprinklers", notSendSprinklers);
        }

        if (!model.containsAttribute("notSendDrips")) {
            List<AuthViewModel> notSendDrips = adminService.getNotSendDrips();
            model.addAttribute("notSendDrips", notSendDrips);
        }

        if (!model.containsAttribute("notSendPumps")) {
            List<AuthViewModel> notSendPumps = adminService.getNotSendPumps();
            model.addAttribute("notSendPumps", notSendPumps);
        }

        return "admin";
    }

    @PostMapping()
    public String sendOrders(AdminDTO adminDTO) {
        adminService.sendOrder(adminDTO);
        return "redirect:/admin";
    }

    @DeleteMapping()
    public String deleteOffer(AdminDTO adminDTO) {

        adminService.deleteProductOrderById(adminDTO);
        return "redirect:/admin";
    }
}
