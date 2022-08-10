package com.example.irrigation2.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String firstName;
    private String lastName;
    private String password;

    @Column(unique = true)
    private String email;
    private String address;
    private String phone;
    public Integer authority;

    public boolean isActive;
    public LocalDateTime confirmedOrder;

    @OneToMany(fetch = FetchType.EAGER)
    private List<RoleEntity> role = new ArrayList<>();

//    @OneToMany
//    private List<ProjectEntity> project;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<DripNumbers> usersDrip;

    private String url;

    public UserEntity() {
    }

    public UserEntity setActive(boolean active) {
        isActive = active;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }


    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public List<RoleEntity> getRole() {
        return role;
    }

    public UserEntity setRole(List<RoleEntity> role) {
        this.role = role;
        return this;
    }

    public Integer getAuthority() {
        return authority;
    }

    public UserEntity setAuthority(Integer authority) {
        this.authority = authority;
        return this;
    }

    public LocalDateTime getConfirmedOrder() {
        return confirmedOrder;
    }

    public UserEntity setConfirmedOrder(LocalDateTime confirmedOrder) {
        this.confirmedOrder = confirmedOrder;
        return this;
    }

    public List<DripNumbers> getUsersDrip() {
        return usersDrip;
    }

    public UserEntity setUsersDrip(List<DripNumbers> usersDrip) {
        this.usersDrip = usersDrip;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public UserEntity setUrl(String url) {
        this.url = url;
        return this;
    }
}
