package com.stackroute.playerservice.controllers;

import com.stackroute.playerservice.exceptions.PlayerAlreadyExitsException;
import com.stackroute.playerservice.exceptions.PlayerNotFoundException;
import com.stackroute.playerservice.services.PlayerServiceImpl;
import com.stackroute.playerservice.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class PlayerController {

    private PlayerServiceImpl playerServiceImpl;

    @Autowired
    public PlayerController(PlayerServiceImpl playerServiceImpl) {
        this.playerServiceImpl = playerServiceImpl;
    }

    /* This method savePlayer is mapped to or called when there is a POST request to add a new player.*/

    @PostMapping("player")
    public ResponseEntity<?> savePlayer(@RequestBody @Valid Player player)throws PlayerAlreadyExitsException{

        Player savedPlayer = playerServiceImpl.savePlayer(player);
        ResponseEntity<?> responseEntity = new ResponseEntity<Player>(savedPlayer,HttpStatus.CREATED);

        return responseEntity;
    }

    /* This method deletePlayer is mapped to or called when there is a DELETE request to delete an existing player.*/

    @DeleteMapping("player")
    public void deletePlayer(@RequestBody @Valid Player player){
        playerServiceImpl.deletePlayer(player);
    }

    /* This method getPlayer is mapped to or called when there is a GET request to get a existing player's data.
    * by his/her id.
    */

    @GetMapping("player/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable("id") int id)throws PlayerNotFoundException{

        Player foundPlayer = playerServiceImpl.getPlayer(id);
        ResponseEntity<?> responseEntity = new ResponseEntity<Player>(foundPlayer,HttpStatus.OK);

        return responseEntity;
    }

    /* This method getPlayerByName is mapped to or called when there is a GET request to get a existing player's
     *  data by his/her name.
     */

    @GetMapping("players/{name}")
    public ResponseEntity<List> getPlayerByName(@PathVariable("name") String name){
        List<Player> playerList = playerServiceImpl.getPlayerByName(name);
        return new ResponseEntity<List>(playerList,HttpStatus.OK);
    }

    /* This method getAllPlayers is mapped to or called when there is a GET request to show all player data.*/

    @GetMapping("players")
    public ResponseEntity<List> getAllPlayers(){
        List<Player> playerList = playerServiceImpl.getAllPlayers();
        return new ResponseEntity<List>(playerList,HttpStatus.OK);
    }

    /* This method updatePlayer is mapped to or called when there is a PUT request to update data of a
     * existing player.
     */

    @PutMapping("player/{id}")
    public ResponseEntity<Player> updatePlayer(@RequestBody @Valid Player player, @PathVariable("id") int id){
        Player updatedPlayer = playerServiceImpl.updatePlayer(player,id);
        return new ResponseEntity<Player>(updatedPlayer, HttpStatus.CREATED);
    }
}
