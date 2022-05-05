package com.gamingCafe;

import com.gamingCafe.controller.OwnsController;
import com.gamingCafe.model.Game;
import com.gamingCafe.model.UsrLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsrPage {

    @Autowired
    private OwnsController ownsCtrl;
    
}
