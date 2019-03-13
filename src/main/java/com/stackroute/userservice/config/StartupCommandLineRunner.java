package com.stackroute.userservice.config;

import com.stackroute.userservice.domain.Player;
import com.stackroute.userservice.exceptions.PlayerAlreadyExitsException;
import com.stackroute.userservice.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupCommandLineRunner  implements CommandLineRunner {

    @Autowired
    private PlayerService playerService;

    @Override
    public void run(String... args) throws Exception {
        try {
            playerService.saveUser(new Player(3,"Sounak",100));
            playerService.saveUser(new Player(4,"Kunal",100));
        } catch (PlayerAlreadyExitsException e) {
            e.printStackTrace();
        }
    }
}
