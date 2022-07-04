package com.example.irrigation.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    @Column(unique = true)
    private String email;
    private String address;
    private String phone;

    @OneToMany(fetch = FetchType.EAGER)
    private List<RoleEntity> role = new ArrayList<>();

    @OneToMany
    private List<ProjectEntity> project;

    public UserEntity() {
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

    public List<ProjectEntity> getProject() {
        return project;
    }

    public UserEntity setProject(List<ProjectEntity> project) {
        this.project = project;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserEntity setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
