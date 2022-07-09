package com.example.irrigation.model.DTO;

import javax.persistence.Column;
import javax.validation.constraints.*;

public class UserRegisterDTO {


    private String firstName;

    private String lastName;


    private String email;

    private String password;

    private String confirmPassword;

    public UserRegisterDTO() {
    }

    @NotBlank(message = "Името трябва да съдържа повече от 2 символа.")
    @Size(min = 2, max = 20, message = "Името трябва да съдържа между 2 и 20 символа.")
    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @NotBlank(message = "Фамилията трябва да съдържа повече от 2 символа.")
    @Size(min = 2, max = 20, message = "Фамилията трябва да съдържа между 2 и 20 символа.")
    public String getLastName() {
        return lastName;
    }

    public UserRegisterDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Email(regexp = "^[\\w -\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Моля, въведете валиден имейл")
    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank(message = "Паролата трябва да съдържа повече от 3 символа.")
    @Size(min = 2, max = 20, message = "Паролата трябва да съдържа между 3 и 20 символа.")
    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotNull(message = "Паролите трябва да съвпадат.")
    public String getConfirmPassword() {

        if (confirmPassword == null) {
            return null;
        } else if (confirmPassword.equals(password)){
            return confirmPassword;
        }
        return null;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
