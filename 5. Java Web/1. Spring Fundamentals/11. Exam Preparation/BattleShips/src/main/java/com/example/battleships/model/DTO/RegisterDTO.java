package com.example.battleships.model.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterDTO {

    @NotBlank(message = "Username cannot be empty.")
    @Size(min = 3, max = 10)
    private String username;
    @NotBlank(message = "Full name cannot be empty.")
    @Size(min = 5, max = 20)
    private String fullName;

    @Email
    private String email;
    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 3)
    private String password;

    @NotBlank(message = "Password cannot be empty.")
    private String confirmPassword;

    public RegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public RegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public RegisterDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
