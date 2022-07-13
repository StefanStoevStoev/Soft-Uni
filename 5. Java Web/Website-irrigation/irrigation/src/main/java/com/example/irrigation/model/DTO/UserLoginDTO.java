package com.example.irrigation.model.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginDTO {

    @NotBlank(message = "Имейлът трябва да съдържа поне 4 символа.")
    @Email(regexp = "^[\\w -\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Моля, въведете валиден имейл.")
    private String username;

    @NotBlank(message = "Паролата трябва да съдържа повече от 3 символа.")
    @Size(min = 2, max = 20, message = "Паролата трябва да съдържа между 3 и 20 символа.")
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
