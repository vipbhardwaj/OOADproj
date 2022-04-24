package com.gamingCafe.controller;

import java.util.List;

import com.gamingCafe.model.Game;
import com.gamingCafe.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    
    @Autowired
    private GameService gameService;

    @RequestMapping("/login")
    public List<Game> getAllGames() {
        List<Game> gamesList = gameService.getAllGames();
        gamesList.forEach(g -> System.out.println(g.getName()));
        return gamesList;
    }
}
