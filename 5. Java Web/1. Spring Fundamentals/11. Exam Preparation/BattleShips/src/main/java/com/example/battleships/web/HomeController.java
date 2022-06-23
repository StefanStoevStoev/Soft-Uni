package com.example.battleships.web;

import com.example.battleships.model.DTO.FireDTO;
import com.example.battleships.model.service.ShipFireServiceModel;
import com.example.battleships.service.ShipService;
import com.example.battleships.service.UserService;
import com.example.battleships.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ShipService shipService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, ShipService shipService, ModelMapper modelMapper, UserService userService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/")
    public String indexLoggedOut() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {

        if (currentUser.getId() == 0) {
            return "index";
        }

        if (this.userService.isLoggedIn()) {
            model.addAttribute("ships", this.shipService.getAllShips());
            return "home";
        }
        return "home";
    }

    @PostMapping("/home")
    public String homeAttack(@Valid FireDTO fireDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("fireDTO", fireDTO);
            redirectAttributes.
                    addFlashAttribute("org.springframework.validation.BindingResult.fireDTO", bindingResult);
        }

        this.shipService.fire(this.modelMapper.map(fireDTO, ShipFireServiceModel.class));
        return "redirect:home";
    }

    @GetMapping("/logout")
    public String logout() {
        currentUser.logout();
        return "redirect:";
    }

    @ModelAttribute("fireDTO")
    public FireDTO initForm(){
        return new FireDTO();
    }
}
