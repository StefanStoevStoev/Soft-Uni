package com.example.coffeeshop2.model.entity.DTO;

import com.example.coffeeshop2.model.entity.CategoryEntity;
import com.example.coffeeshop2.model.entity.enums.ProductEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDTO {

    @NotBlank(message = "Name cannot be blank.")
    @Size(min = 3, max = 20, message = "Username size must be between 3 and 20 characters.")
    private String name;

    @Positive
    private BigDecimal price;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @PastOrPresent( message = "Order date cannot be in future.")
    private LocalDateTime orderTime;

    @NotNull(message = "You must select category.")
    private ProductEnum category;

    @Size(min = 3, message = "Description size must be at least 5 characters.")
    private String description;

    public OrderDTO() {
    }

    public String getName() {
        return name;
    }

    public OrderDTO setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderDTO setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public ProductEnum getCategory() {
        return category;
    }

    public OrderDTO setCategory(ProductEnum category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
