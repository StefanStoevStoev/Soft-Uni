package com.example.irrigation.model.views;

import javax.validation.constraints.NotBlank;

public class UserViewModel {

    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;
    @NotBlank
    public Integer authority;

//    public UserViewModel(Long id,
//                         String firstName,
//                         String lastName,
//                         String email,
//                         String address,
//                         String phone,
//                         Integer authority) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.address = address;
//        this.phone = phone;
//        this.authority = authority;
//    }

    public UserViewModel() {
        super();
    }

    public Long getId() {
        return id;
    }

    public UserViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserViewModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserViewModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Integer getAuthority() {
        return authority;
    }

    public UserViewModel setAuthority(Integer authority) {
        this.authority = authority;
        return this;
    }
}
