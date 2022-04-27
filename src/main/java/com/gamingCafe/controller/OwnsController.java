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

    public List<String> getOwnsByUsr(String email) {
        List<String> ownsList = ownsService.getOwnsByUser(email);
        System.out.println("Returning Ownss for : " + email + "\n\n\n\n\n");
        return ownsList;
    }

    // public void buyOwns(Owns g) {
    //     ownsService.createOwns(g);
    // }
}
