package com.gamingCafe.controller;

import com.gamingCafe.model.UsrLogin;
import com.gamingCafe.service.UsrLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsrLoginController {
    @Autowired
    private UsrLoginService usrLoginService;

    // @RequestMapping("/usr-login")
    // public UsrLogin checkIfUserExists(String email, String pwd) {
    //     UsrLogin usr = usrLoginService.checkIfUserExists(email, pwd);
        
    //     if(usr != null)
    //         System.out.println("\n\n\nUser exists");
    //     else
    //         System.out.println("\n\n\nUser does not exist");
        
    //     return usr;
    // }

}
