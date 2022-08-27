package com.example.irrigation2.model.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AuthDTO {

    private Long id;
    @NotBlank(message = "Името трябва да съдържа повече от 2 символа.")
    @Size(min = 2, max = 20, message = "Името трябва да съдържа между 2 и 20 символа.")
    private String firstName;
    @NotBlank(message = "Фамилията трябва да съдържа повече от 2 символа.")
    @Size(min = 2, max = 20, message = "Фамилията трябва да съдържа между 2 и 20 символа.")
    private String lastName;
    @NotBlank
    @Email(regexp = "^[\\w -\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Моля, въведете валиден имейл")
    private String email;

    @NotBlank(message = "Градът трябва да съдържа повече от 2 символа.")
    @Size(min = 2, max = 20, message = "Градът трябва да съдържа между 2 и 20 символа.")
    private String city;

    @NotBlank(message = "Адресът трябва да съдържа повече от 10 символа.")
    @Size(min = 10, max = 50, message = "Адресът трябва да съдържа между 10 и 50 символа.")
    private String address;
    @NotBlank
    //Take only last 10 digits. For first 10digits - ^[0-9]{10}|$^
    @Pattern(regexp="(^$|[0-9]{10}$)", message = "Номерът трябва да съдържа 10 цифри!")
    private String phone;

    public Integer authority;

    public AuthDTO() {
    }

    public String getCity() {
        return city;
    }

    public AuthDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public Long getId() {
        return id;
    }

    public AuthDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public AuthDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AuthDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AuthDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AuthDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public AuthDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Integer getAuthority() {
        return authority;
    }

    public AuthDTO setAuthority(Integer authority) {
        this.authority = authority;
        return this;
    }
}
