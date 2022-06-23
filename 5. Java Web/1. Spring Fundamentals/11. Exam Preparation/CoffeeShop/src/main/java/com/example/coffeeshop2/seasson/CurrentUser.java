package com.example.coffeeshop2.seasson;

import com.example.coffeeshop2.model.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private long id;
    private String  username;

    public CurrentUser() {
    }

    public void login(UserEntity userEntity){
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
    }

    public void logout() {
        this.id = 0;
        this.username = null;
    }

    public long getId() {
        return id;
    }

    public CurrentUser setId(long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }
}
