package com.example.irrigation2.model.DTO;

import com.example.irrigation2.model.validation.FieldMatch;

import javax.validation.constraints.*;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords do not match."
)
public class UserRegisterDTO {

    @NotBlank(message = "Името трябва да съдържа повече от 2 символа.")
    @Size(min = 2, max = 20, message = "Името трябва да съдържа между 2 и 20 символа.")
    private String firstName;
    @NotBlank(message = "Фамилията трябва да съдържа повече от 2 символа.")
    @Size(min = 2, max = 20, message = "Фамилията трябва да съдържа между 2 и 20 символа.")
    private String lastName;
    @Email(regexp = "^[\\w -\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Моля, въведете валиден имейл")
    private String email;
    @NotBlank(message = "Паролата трябва да съдържа повече от 3 символа.")
    @Size(min = 2, max = 20, message = "Паролата трябва да съдържа между 3 и 20 символа.")
    private String password;

    private String confirmPassword;

    public UserRegisterDTO() {
    }


    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }


    public String getLastName() {
        return lastName;
    }

    public UserRegisterDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }
//    public String getEmail() {
//        return "stoev.stefan@gmail.com";
//    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }


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
