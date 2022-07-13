package com.example.irrigation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class DripsController {

    @GetMapping("/drip")
    public String drip(){
        return "products-drip";
    }}
