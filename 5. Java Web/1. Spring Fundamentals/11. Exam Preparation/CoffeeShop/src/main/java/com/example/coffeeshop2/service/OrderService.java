package com.example.coffeeshop2.service;

import com.example.coffeeshop2.model.entity.DTO.OrderDTO;
import com.example.coffeeshop2.model.entity.OrderEntity;
import com.example.coffeeshop2.model.entity.view.OrderViewModel;
import com.example.coffeeshop2.repositories.OrderRepository;
import com.example.coffeeshop2.seasson.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;
    private final CategoryService categoryService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public OrderService(ModelMapper modelMapper,
                        OrderRepository orderRepository,
                        CategoryService categoryService,
                        UserService userService, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.orderRepository = orderRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    public boolean insertProduct(OrderDTO orderDTO){
        OrderEntity order = modelMapper.map(orderDTO, OrderEntity.class);

        order.setCategory(categoryService.findByProductEnum(orderDTO.getCategory()));
        order.setEmployee(userService.findByUserId(currentUser.getId()));

        orderRepository.save(order);
        return true;
    }

    public List<OrderViewModel> findAllOrderByPriceDesc(){
        return orderRepository.findAllByOrderByPriceDesc()
                .stream().map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    public void readyOrder(Long id){
        orderRepository.deleteById(id);
    }
}
