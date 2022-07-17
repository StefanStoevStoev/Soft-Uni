package com.example.irrigation.init;

import com.example.irrigation.service.DripService;
import com.example.irrigation.service.SprinklerService;
import com.example.irrigation.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInit implements CommandLineRunner {

    private final UserService userService;
    private final DripService dripService;
    private final SprinklerService sprinklerService;

    public AppInit(UserService userService, DripService dripService, SprinklerService sprinklerService) {
        this.userService = userService;
        this.dripService = dripService;
        this.sprinklerService = sprinklerService;
    }

    @Override
    public void run(String... args) {
        userService.init();
        dripService.initDrips();
        sprinklerService.initSprinklers();

    }
}























