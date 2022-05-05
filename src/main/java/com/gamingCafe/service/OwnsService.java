package com.gamingCafe.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.gamingCafe.model.Owns;
import com.gamingCafe.repository.OwnsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnsService {

    @Autowired
    private OwnsRepository ownsRepository;
    
    public List<Owns> getAllOwns() {
        List<Owns> ownsList = new ArrayList<>();
        ownsRepository.findAll().forEach(ownsList::add);
        return ownsList;
    }

    public List<Owns> getOwnsByUser(String e) {
        List<Owns> gameList = new ArrayList<>();
        ownsRepository.findAllBypEmail(e).forEach(gameList::add);
        return gameList;
    }

    public void addGameForPlayer(String e, String g) {
        Owns owns = new Owns(e, g);
        ownsRepository.save(owns);
        System.out.println("Game Bought\n\n\n\n");
        return;
    }

    public void deleteGameForPlayer(String e, String g) {
        ownsRepository.deleteBypEmailAndGid(e, g);
        System.out.println("Game Deleted\n\n\n\n");
        return;
    }
}