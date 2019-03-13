package com.stackroute.playerservice.services;

import com.stackroute.playerservice.domain.Player;
import com.stackroute.playerservice.exceptions.PlayerAlreadyExitsException;
import com.stackroute.playerservice.exceptions.PlayerNotFoundException;

import java.util.List;

public interface PlayerService {
    public Player savePlayer(Player player)throws PlayerAlreadyExitsException;
    public void deletePlayer(Player player);
    public Player getPlayer(int id) throws PlayerNotFoundException;
    public List<Player> getPlayerByName(String name);
    public List<Player> getAllPlayers();
    public Player updatePlayer(Player player, int id);
}
