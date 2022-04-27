package com.gamingCafe.service;

import java.util.ArrayList;
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

    public List<String> getOwnsByUser(String e) {
        List<String> gameList = new ArrayList<>();
        for(Owns o: ownsRepository.findAll()) {
            if(o.p_email.equals(e)) {
                gameList.add(o.g_id);
            }
        }
        return gameList;
    }

    // public void createOwns(Owns o) {
    //     ownsRepository.save(o);
    // }
}