package com.example.irrigation.model.DTO;

import com.example.irrigation.model.validation.FieldMatch;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

//@FieldMatch(
//        first = "phone",
//        second = "address"
//)
public class UserPhoneAndAddressDTO {

    @NotBlank
    @Pattern(regexp="(^$|[0-9]{10}$)", message = "Номерът трябва да съдържа 10 цифри!")
    private String phone;

    @NotBlank
    private String address;

    public UserPhoneAndAddressDTO() {
    }

    public String getPhone() {
        return phone;
    }

    public UserPhoneAndAddressDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserPhoneAndAddressDTO setAddress(String address) {
        this.address = address;
        return this;
    }
}
