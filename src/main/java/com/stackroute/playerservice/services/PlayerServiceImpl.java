package com.stackroute.playerservice.services;

import com.stackroute.playerservice.domain.Player;
import com.stackroute.playerservice.exceptions.PlayerAlreadyExitsException;
import com.stackroute.playerservice.exceptions.PlayerNotFoundException;
import com.stackroute.playerservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    public void setPlayerRepository(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /* This method savePlayer adds a new player to database if already does not exists.
     * Else it will throw exception
     */

    public Player savePlayer(Player player) throws PlayerAlreadyExitsException {

        if (playerRepository.existsById(player.getId()))
            throw new PlayerAlreadyExitsException("Player Already Exists! " + HttpStatus.CONFLICT);

        Player savedPlayer = playerRepository.save(player);
        return savedPlayer;
    }

    /* This method deletePlayer deletes a player from database if already exists.
     * Else it will throw exception
     */

    public void deletePlayer(Player player){
        playerRepository.delete(player);
    }

    /* This method getPlayer fetches a player information from database if already exists.
     * Else it will throw exception
     */

    public Player getPlayer(int id) throws PlayerNotFoundException {
        if (!playerRepository.existsById(id))
            throw new PlayerNotFoundException("Player Not Found!" + HttpStatus.NOT_FOUND);

        Optional<Player> Player = playerRepository.findById(id);
        return Player.get();
    }

    /* This method getAllPlayerByName finds a player's information from database if already exists.
     * Else it will throw exception
     */

    public List<Player> getPlayerByName(String name){
        return playerRepository.findByName(name);
    }

    /* This method getAllPlayers fetches information of all player in the database. */

    public List<Player> getAllPlayers(){
        List<Player> allPlayers = (List<Player>) playerRepository.findAll();
        return allPlayers;
    }

    /* This method updatePlayer updates a player's information to database if already exists.
     * Else it will throw exception
     */

    public Player updatePlayer(Player player, int id){
        player.setId(id);
        return playerRepository.save(player);
    }

}
