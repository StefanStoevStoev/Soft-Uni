package com.example.battleships.model.DTO;

import javax.validation.constraints.NotBlank;

public class LoginDTO {

    @NotBlank(message = "Username cannot be empty.")
    private String username;
    @NotBlank(message = "Password cannot be empty.")
    private String password;

    public LoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public LoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
