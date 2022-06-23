package com.example.coffeeshop2.web;

import com.example.coffeeshop2.model.entity.DTO.OrderDTO;
import com.example.coffeeshop2.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @ModelAttribute("orderDTO")
    private OrderDTO initForm(){
        return new OrderDTO();
    }

    @GetMapping("/add")
    public String add(){
        return "order-add";
    }

    @PostMapping("/add")
    public String add(@Valid OrderDTO orderDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors() || !this.orderService.insertProduct(orderDTO)){
            redirectAttributes.addFlashAttribute("orderDTO", orderDTO);
            redirectAttributes.
                    addFlashAttribute("org.springframework.validation.BindingResult.orderDTO", bindingResult);
            return "redirect:/add";
        }
        return "redirect:home";
    }
    @GetMapping("/ready/{id}")
    public String ready(@PathVariable Long id){
        orderService.readyOrder(id);

        return "redirect:/";
    }

}
