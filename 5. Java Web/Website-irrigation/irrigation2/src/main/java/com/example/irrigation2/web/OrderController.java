package com.example.irrigation2.web;

import com.example.irrigation2.model.DTO.DripDTO;
import com.example.irrigation2.model.DTO.OrderDTO;
import com.example.irrigation2.model.entity.DripEntity;
import com.example.irrigation2.model.entity.SprinklerEntity;
import com.example.irrigation2.model.views.UserViewModel;
import com.example.irrigation2.service.DripService;
import com.example.irrigation2.service.SprinklerService;
import com.example.irrigation2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/auth-home")
public class OrderController {

    private final DripService dripService;
    private final SprinklerService sprinklerService;
    private final UserService userService;

    public OrderController(DripService dripService, SprinklerService sprinklerService, UserService userService) {
        this.dripService = dripService;
        this.sprinklerService = sprinklerService;
        this.userService = userService;
    }

    //button потвърди
    @GetMapping("/{id}/orders")
    public String orderList(@PathVariable("id") Long id, Model model) {
        if (!model.containsAttribute("orderDripDTO")) {
            model.addAttribute("orderDripDTO", new OrderDTO());
        }
        if (!model.containsAttribute("dripNumsByUser")) {
            List<DripEntity> dripNumsByUser = dripService.getOrdersByUser(id); //
            model.addAttribute("dripNumsByUser", dripNumsByUser);
        }
        if (!model.containsAttribute("sprinklerNumsByUser")) {
            List<SprinklerEntity> sprinklerNumsByUser = sprinklerService.getOrdersByUser(id); //
            model.addAttribute("sprinklerNumsByUser", sprinklerNumsByUser);
        }

        if (model.containsAttribute("userDetails")) {
            UserViewModel user = userService.getUserById(id);
            model.addAttribute("userDetails", user);
        }

        model.addAttribute("getUserId", id);
        return "my-orders";
    }

    //button потвърди
    @PostMapping("/{id}/orders")
    public String addUser(@PathVariable("id") Long id,
                          OrderDTO orderDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderDTO", orderDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.orderDTO", bindingResult);
            return "redirect:/auth-home/" + id + "/orders";
        }
        if (orderDTO.getName().equals("drip")) {
            dripService.orderDripToUser(orderDTO, id);
        } else if (orderDTO.getName().equals("sprinkler")) {
            sprinklerService.orderDripToUser(orderDTO, id);
        }
        return "redirect:/auth-home/" + id + "/orders";
    }

    @DeleteMapping("/{id}")
    public String deleteOffer(
            @PathVariable("id") Long userId, DripDTO dripDTO) {
        dripService.deleteDripById(dripDTO.getId(), userId);
        return "redirect:/auth-home/" + userId;
    }
}
