package com.stackroute.userservice.config;

import com.stackroute.userservice.domain.Player;
import com.stackroute.userservice.exceptions.PlayerAlreadyExitsException;
import com.stackroute.userservice.services.PlayerService;
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
    private PlayerService playerService;

    @Autowired
    Environment env;

    @Value("${id}")
    int id;

    @Value("${score}")
    int score;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            playerService.saveUser(new Player(id,env.getProperty("name"),score));
        } catch (PlayerAlreadyExitsException e) {
            e.printStackTrace();
        }
    }
}
