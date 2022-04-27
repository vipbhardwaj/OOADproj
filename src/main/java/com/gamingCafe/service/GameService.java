package com.gamingCafe.service;

import java.util.ArrayList;
import java.util.List;

import com.gamingCafe.model.Game;
import com.gamingCafe.repository.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    
    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        gameRepository.findAll().forEach(games::add);
        return games;
    }
}