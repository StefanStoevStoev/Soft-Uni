package com.example.coffeeshop2.model.entity.DTO;

import javax.validation.constraints.NotBlank;

public class UserLoginDTO {

    @NotBlank(message = "Username cannot be blank.")
    private String username;
    @NotBlank(message = "Password cannot be blank.")
    private String password;

    public UserLoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
