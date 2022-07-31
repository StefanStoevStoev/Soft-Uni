package com.example.irrigation2.init;

import com.example.irrigation2.service.DripService;
import com.example.irrigation2.service.PumpService;
import com.example.irrigation2.service.SprinklerService;
import com.example.irrigation2.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInit implements CommandLineRunner {

    private final UserService userService;
    private final DripService dripService;
    private final SprinklerService sprinklerService;
    private final PumpService pumpService;

    public AppInit(UserService userService, DripService dripService, SprinklerService sprinklerService, PumpService pumpService) {
        this.userService = userService;
        this.dripService = dripService;
        this.sprinklerService = sprinklerService;
        this.pumpService = pumpService;
    }

    @Override
    public void run(String... args) {
        userService.init();///////////
        dripService.initDrips();
        sprinklerService.initSprinklers();
        pumpService.initPumps();

    }
}
