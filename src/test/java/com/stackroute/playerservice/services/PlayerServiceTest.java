package com.stackroute.playerservice.services;

import com.stackroute.playerservice.domain.Player;
import com.stackroute.playerservice.exceptions.PlayerAlreadyExitsException;
import com.stackroute.playerservice.repository.PlayerRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PlayerServiceTest {

    private Player player;

    //Create a mock for playerRepository
    @Mock
    private PlayerRepository playerRepository;

    //Inject the mocks as dependencies into PlayerServiceImpl
    @InjectMocks
    private PlayerServiceImpl playerService;
    List<Player> list = null;


    @Before
    public void setUp() throws Exception {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        player = new Player();
        player.setId(16);
        player.setName("Santhosh");
        player.setScore(200);
        list = new ArrayList<>();
        list.add(player);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void savePlayerTestSuccess()throws PlayerAlreadyExitsException {
        //stubbing the mock to return specific data
        when(playerRepository.save((Player)any())).thenReturn(player);
        Player savedPlayer = playerService.savePlayer(player);
        Assert.assertEquals(player,savedPlayer);

        //verify here verifies that playerRepository save method is only called once
        verify(playerRepository,times(1)).save(player);
    }

    @Test(expected = PlayerAlreadyExitsException.class)
    public void savePlayerTestFailure() throws PlayerAlreadyExitsException{
        //stubbing the mock to return specific data
        when(playerRepository.save((Player)any())).thenReturn(null);

        Player savedPlayer = playerService.savePlayer(player);
        System.out.println("savedPlayer : "+ savedPlayer);
        Assert.assertNotEquals(player,savedPlayer);
    }

//    @Test
//    public void getPlayerTest(){
//        Optional<Player> optionalPlayer = new Optional<>();
//
//        //when(playerRepository.findById((int)any())).thenReturn();
//    }

    @Test
    public void deletePlayerTest(){
        playerService.deletePlayer(player);

        //verify here verifies that playerRepository delete method is only called once
        verify(playerRepository,times(1)).delete(player);
    }

    @Test
    public void getAllPlayersTest(){
        playerRepository.save(player);
        //stubbing the mock to return specific data
        when(playerRepository.findAll()).thenReturn(list);
        List<Player> playerList = playerService.getAllPlayers();
        Assert.assertEquals(list,playerList);
    }
}