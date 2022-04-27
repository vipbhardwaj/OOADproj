package com.gamingCafe.controller;

import java.util.List;

import com.gamingCafe.model.Game;
import com.gamingCafe.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    
    @Autowired
    private GameService gameService;

    public List<Game> getAllGames() {
        List<Game> gamesList = gameService.getAllGames();
        System.out.println("Returning Games\n\n\n\n\n");
        return gamesList;
    }
    
}
