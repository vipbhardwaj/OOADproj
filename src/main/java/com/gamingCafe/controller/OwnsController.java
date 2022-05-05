package com.gamingCafe.controller;

import java.util.List;

import com.gamingCafe.model.Owns;
import com.gamingCafe.service.OwnsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnsController {
    
    @Autowired
    private OwnsService ownsService;

    public List<Owns> getAllOwns() {
        List<Owns> ownsList = ownsService.getAllOwns();
        System.out.println("Returning ALLLL Ownss\n\n\n\n\n");
        return ownsList;
    }

    public List<Owns> getOwnsByUsr(String email) {
        List<Owns> ownsList = ownsService.getOwnsByUser(email);
        System.out.println("Returning Ownss for : " + email + "\n\n\n\n\n");
        return ownsList;
    }

    public void addGameForPlayer(String email, String gameId) {
        System.out.println("Buy clicked for : " + email + " and game : " + gameId + "\n\n\n\n\n");
        ownsService.addGameForPlayer(email, gameId);
        return;
    }

    public void deleteGameForPlayer(String email, String gameId) {
        System.out.println("Delete clicked for : " + email + " and game : " + gameId + "\n\n\n\n\n");
        ownsService.deleteGameForPlayer(email, gameId);
        return;
    }
}
