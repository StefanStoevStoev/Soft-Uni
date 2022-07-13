package com.example.irrigation.init;

import com.example.irrigation.service.DripService;
import com.example.irrigation.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInit implements CommandLineRunner {

    private final UserService userService;
    private final DripService dripService;

    public AppInit(UserService userService, DripService dripService) {
        this.userService = userService;
        this.dripService = dripService;
    }

    @Override
    public void run(String... args) {
        userService.init();
        dripService.initDrips();

    }
}























