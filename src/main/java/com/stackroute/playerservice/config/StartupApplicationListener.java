package com.stackroute.playerservice.config;

import com.stackroute.playerservice.services.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PlayerServiceImpl playerServiceImpl;

    @Autowired
    Environment env;

    @Value("${id}")
    int id;

    @Value("${score}")
    int score;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("\n*****INSIDE ApplicationListener*****\n");

        /* Seed data Code has been commented out to avoid PlayerAlreadyExistsException as same data is being
         * seeded into mongodb database every time on start up.
         */

//        try {
//            playerServiceImpl.savePlayer(new Player(id,env.getProperty("name"),score));
//        } catch (PlayerAlreadyExitsException e) {
//            e.printStackTrace();
//        }
    }
}
