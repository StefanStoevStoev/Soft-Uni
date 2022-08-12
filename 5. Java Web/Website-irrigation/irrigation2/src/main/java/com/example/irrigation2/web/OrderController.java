package com.example.irrigation2.web;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.model.DTO.OrderDripDTO;
import com.example.irrigation2.model.entity.DripEntity;
import com.example.irrigation2.model.views.UserViewModel;
import com.example.irrigation2.service.DripService;
import com.example.irrigation2.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/auth-home")
public class OrderController {

    private final DripService dripService;
    private final UserService userService;

    public OrderController(DripService dripService, UserService userService) {
        this.dripService = dripService;
        this.userService = userService;
    }

    @GetMapping("/{id}/orders")
    public String orderList(@PathVariable("id") Long id, Model model){
        if(!model.containsAttribute("orderDripDTO")){
            model.addAttribute("orderDripDTO", new OrderDripDTO());
        }
        List<DripEntity> dripNumsByUser = dripService.getDripNumsByUser(id);
        model.addAttribute("dripNumsByUser", dripNumsByUser);

        UserViewModel user = userService.getUserById(id);
        model.addAttribute("userDetails", user);
        model.addAttribute("getUserId", id);
        return "my-orders";
    }
    @PostMapping("/{id}/orders")
    public String addUser(@PathVariable("id") Long id,
                          OrderDripDTO orderDripDTO,
                          RedirectAttributes redirectAttributes,
                          @AuthenticationPrincipal CurrentUserDetails currentUser) {

        redirectAttributes.addFlashAttribute("orderDripDTO", orderDripDTO);
        redirectAttributes.addFlashAttribute("uId", id);
        dripService.orderDripToUser(orderDripDTO, id);
        return "redirect:/auth-home/" + id + "/orders";
    }
}
