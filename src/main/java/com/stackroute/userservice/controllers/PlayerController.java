package com.stackroute.userservice.controllers;

import com.stackroute.userservice.exceptions.PlayerAlreadyExitsException;
import com.stackroute.userservice.exceptions.PlayerNotFoundException;
import com.stackroute.userservice.services.PlayerService;
import com.stackroute.userservice.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("player")
    public ResponseEntity<?> saveUser(@RequestBody Player player){

        Player savedPlayer = null;
        ResponseEntity<?> responseEntity;
        try {
            savedPlayer = playerService.saveUser(player);
            responseEntity = new ResponseEntity<Player>(savedPlayer,HttpStatus.OK);
        } catch (PlayerAlreadyExitsException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            e.printStackTrace();
        }

        return responseEntity;
    }

    @DeleteMapping("player")
    public void deleteUser(@RequestBody Player player){
        playerService.deleteUser(player);
    }

    @GetMapping("player/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable("id") int id){

        Player foundPlayer = null;
        ResponseEntity<?> responseEntity;
        try {
            foundPlayer = playerService.getUser(id);
            responseEntity = new ResponseEntity<Player>(foundPlayer,HttpStatus.OK);
        } catch (PlayerNotFoundException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("players/{name}")
    public ResponseEntity<List> getPlayerByName(@PathVariable("name") String name){
        List<Player> playerList = playerService.getPlayerByName(name);
        return new ResponseEntity<List>(playerList,HttpStatus.OK);
    }

    @GetMapping("players")
    public ResponseEntity<List> getAllPlayers(){
        List<Player> playerList = playerService.getAllUsers();
        return new ResponseEntity<List>(playerList,HttpStatus.OK);
    }

    @PutMapping("player/{id}")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player, @PathVariable("id") int id){
        Player updatedPlayer = playerService.updateUser(player,id);
        return new ResponseEntity<Player>(updatedPlayer, HttpStatus.OK);
    }
}
