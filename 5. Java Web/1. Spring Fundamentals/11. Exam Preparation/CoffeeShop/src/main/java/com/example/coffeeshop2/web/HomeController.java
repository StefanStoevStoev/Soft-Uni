package com.example.coffeeshop2.web;

import com.example.coffeeshop2.model.entity.view.OrderViewModel;
import com.example.coffeeshop2.seasson.CurrentUser;
import com.example.coffeeshop2.service.OrderService;
import com.example.coffeeshop2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String loggedOutIndex(){
        return "index";
    }

    @GetMapping("/home")
    public String loggedIntIndex(Model model){
        if(currentUser.getId() == 0) {
            return "index";
        }

        List<OrderViewModel> orders = orderService.findAllOrderByPriceDesc();

        model.addAttribute("orders", orders);
        model.addAttribute("totalTime", orders
                .stream()
                .map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
                .reduce(Integer::sum)
                .orElse(0)
        );
        model.addAttribute("users", userService.findAllUserAndCountOfOrdersByCountDesc());
        return "home";
    }
}
