package com.example.irrigation2.config;

import com.example.irrigation2.model.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomerUserDetails extends UserEntity implements UserDetails {

    private Collection<? extends GrantedAuthority> authorities;

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String address;
    private String phone;
    public Integer authority;

    public CustomerUserDetails(Collection<? extends GrantedAuthority> authorities, String firstName, String lastName, String password, String email, String address, String phone, Integer authority) {
        this.authorities = authorities;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.authority = authority;
    }

    public CustomerUserDetails(UserEntity user) {
        this.email = user.getEmail();
        this.password = user.getPassword();

    }

    public CustomerUserDetails() {
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public CustomerUserDetails setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public CustomerUserDetails setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public CustomerUserDetails setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public CustomerUserDetails setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public CustomerUserDetails setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public CustomerUserDetails setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public Integer getAuthority() {
        return authority;
    }

    @Override
    public CustomerUserDetails setAuthority(Integer authority) {
        this.authority = authority;
        return this;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
