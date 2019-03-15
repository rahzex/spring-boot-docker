package com.stackroute.playerservice.repository;

import com.stackroute.playerservice.domain.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;
    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player();
        player.setId(15);
        player.setName("Meghna");
        player.setScore(90);
    }

    @After
    public void tearDown() throws Exception {
        playerRepository.deleteAll();
    }

    @Test
    public void testFindByName(){
        playerRepository.save(player);
        List<Player> expectedPlayer = new ArrayList<>();
        expectedPlayer.add(player);
        assertEquals(expectedPlayer,playerRepository.findByName("Meghna"));
    }

    @Test
    public void testFindByNameFailure(){
        List<Player> expectedPlayer = new ArrayList<>();
        expectedPlayer.add(player);
        assertNotEquals(expectedPlayer,playerRepository.findByName("MeghnaN"));
    }
}