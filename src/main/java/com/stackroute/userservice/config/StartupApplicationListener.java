package com.stackroute.userservice.config;

import com.stackroute.userservice.domain.Player;
import com.stackroute.userservice.exceptions.PlayerAlreadyExitsException;
import com.stackroute.userservice.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PlayerService playerService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            playerService.saveUser(new Player(1,"Rahul",100));
            playerService.saveUser(new Player(2,"Subhajit",100));
        } catch (PlayerAlreadyExitsException e) {
            e.printStackTrace();
        }
    }
}
