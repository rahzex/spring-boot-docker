package com.stackroute.playerservice.config;

import com.stackroute.playerservice.services.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupCommandLineRunner  implements CommandLineRunner {

    @Autowired
    private PlayerServiceImpl playerServiceImpl;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n*****INSIDE CommandLineListener*****\n");

        /* Seed data Code has been commented out to avoid PlayerAlreadyExistsException as same data is being
         * seeded into mongodb database everytime on start up.
         */

//        try {
//            playerServiceImpl.savePlayer(new Player(3,"Sounak",100));
//            playerServiceImpl.savePlayer(new Player(4,"Kunal",100));
//        } catch (PlayerAlreadyExitsException e) {
//            e.printStackTrace();
//        }
    }
}
