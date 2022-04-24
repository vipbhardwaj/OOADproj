package com.gamingCafe.service;

import com.gamingCafe.model.UsrLogin;
import com.gamingCafe.repository.UsrLoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsrLoginService {
    @Autowired
    private UsrLoginRepository usrLoginRepository;
    
    public UsrLogin checkIfUserExists(String userEmail, String userPwd) {
        UsrLogin user;

        if(!usrLoginRepository.findById(userEmail).isPresent())
            user = null;
        else if(usrLoginRepository.findById(userEmail).get().getPwd().equals(userPwd))
            user = usrLoginRepository.findById(userEmail).get();
        else
            user = null;
        
        return user;
    }
    
}
