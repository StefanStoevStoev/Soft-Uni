package com.example.irrigation.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CurrentUserDetails implements UserDetails {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
    private final Collection<GrantedAuthority> authorities;

    public CurrentUserDetails(Long id,
                              String firstName,
                              String lastName,
                              String password,
                              String email,
                              Collection<GrantedAuthority> authorities) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName(){
        StringBuilder fullName = new StringBuilder();

        if(getFirstName() != null){
            fullName.append(getFirstName());
        }
        if(getLastName() != null){
            if(fullName.length() != 0){
                fullName.append(" ");
            }
            fullName.append(getLastName());
        }
        return fullName.toString();
    }
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getFullName();
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
