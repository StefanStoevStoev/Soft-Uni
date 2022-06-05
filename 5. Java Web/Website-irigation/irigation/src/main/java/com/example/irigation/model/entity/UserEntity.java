package com.example.irigation.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String address;
    private String phone;

    @ManyToOne
    private RoleEntity role;

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

    public RoleEntity getRole() {
        return role;
    }

    public UserEntity setRole(RoleEntity role) {
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
}
