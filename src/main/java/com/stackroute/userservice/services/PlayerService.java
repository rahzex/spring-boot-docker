package com.stackroute.userservice.services;

import com.stackroute.userservice.domain.Player;
import com.stackroute.userservice.exceptions.PlayerAlreadyExitsException;
import com.stackroute.userservice.exceptions.PlayerNotFoundException;
import com.stackroute.userservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    public void setPlayerRepository(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player saveUser(Player player) throws PlayerAlreadyExitsException {

        if (playerRepository.existsById(player.getId()))
            throw new PlayerAlreadyExitsException("Player Already Exists!");

        Player savedPlayer = playerRepository.save(player);
        return savedPlayer;
    }

    public void deleteUser(Player player){
        playerRepository.delete(player);
    }

    public Player getUser(int id) throws PlayerNotFoundException {
        if (!playerRepository.existsById(id))
            throw new PlayerNotFoundException("Player Not Found!");

        Optional<Player> user = playerRepository.findById(id);
        return user.get();
    }

    public List<Player> getPlayerByName(String name){
        return playerRepository.findByPlayerName(name);
    }

    public List<Player> getAllUsers(){
        List<Player> allPlayers = (List<Player>) playerRepository.findAll();
        return allPlayers;
    }

    public Player updateUser(Player player, int id){
        player.setId(id);
        return playerRepository.save(player);
    }

}
