package com.stackroute.playerservice.repository;

import com.stackroute.playerservice.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends MongoRepository<Player,Integer> {

    //@Query("select p from Player p where p.name = ?1")
    List<Player> findByName(String name);   //returns all player having given name
}
