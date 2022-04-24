package com.gamingCafe;

import java.util.List;

import com.gamingCafe.model.Game;
import com.gamingCafe.model.UsrLogin;
import com.gamingCafe.service.GameService;
import com.gamingCafe.service.UsrLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LandingPage {

    @GetMapping("/")
    public String greetingForm(Model model) {
        return "index";
    }

    @Autowired
    private GameService gameService;
    @Autowired
    private UsrLoginService usrLoginService;

    @PostMapping("/usrLogin")
    public String greetingSubmit(
        @RequestParam(value = "usr_email") String email,
        @RequestParam(value = "usr_pwd") String pwd,
        Model model
    ) {
        UsrLogin usr = usrLoginService.checkIfUserExists(email, pwd);
        if(usr != null) {
            System.out.println("\n\n\nUser exists\n\n\n");
            
            model.addAttribute("usr", usr);
            List<Game> gamesList = gameService.getAllGames();
            //gamesList.forEach(game -> System.out.println(game.toString()));
            model.addAttribute("games", gamesList);
            return "usr_logged";
        }
        else {
            System.out.println("\n\n\nUser does not exist\n\n\n");
            model.addAttribute("usr", email);
            return "err_login";
        }
    }
}