package com.gamingCafe;

import java.util.ArrayList;
import java.util.List;

import com.gamingCafe.controller.EmpLoginController;
import com.gamingCafe.controller.GameController;
import com.gamingCafe.controller.OwnsController;
import com.gamingCafe.controller.PackageController;
import com.gamingCafe.controller.UsrLoginController;
import com.gamingCafe.model.EmpLogin;
import com.gamingCafe.model.Game;
import com.gamingCafe.model.Owns;
import com.gamingCafe.model.UsrLogin;
import com.gamingCafe.model.Package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LandingPage {

    @GetMapping("/")
    public String greetingForm(Model model) {
        return "index";
    }

    @Autowired
    private GameController gameController;
    @Autowired
    private UsrLoginController usrLoginController;
    @Autowired
    private PackageController packageController;
    @Autowired
    private OwnsController ownsController;
    
    UsrLogin usr = null;

    @RequestMapping(value = "/usrLogin", method = RequestMethod.GET)
    public String usrLogin(Model model) {
        if(usr != null) {
            model.addAttribute("usr", usr);
            List<Owns> ownsList = ownsController.getOwnsByUsr(usr.getEmail());
            List<Game> gamesList = gameController.getAllGames();
            List<Game> userGames = new ArrayList<>();
            for(Owns owns : ownsList) {
                for(Game game : gamesList) {
                    if(owns.getG_id().equals(game.getId())) {
                        userGames.add(game);
                    }
                }
            }
            model.addAttribute("owns", userGames);
            List<Game> games = new ArrayList<>();
            for(Game game : gamesList) {
                if(!userGames.contains(game)) {
                    games.add(game);
                }
            }
            model.addAttribute("games", games);
            List<Package> pkgList = packageController.getAllPackages();
            model.addAttribute("pkgs", pkgList);
            return "usr_logged";
        } else {
            return "err_login";
        }
    }
    
    @PostMapping("/usrLogin")
    public String usrLogin(
        @RequestParam(value = "usr_email") String email,
        @RequestParam(value = "usr_pwd") String pwd,
        Model model
    ) {
        if(usr == null) {
            usr = usrLoginController.usrLoginCaller(email, pwd);
        }
        if(usr != null) {
            model.addAttribute("usr", usr);
            List<Owns> ownsList = ownsController.getOwnsByUsr(email);
            List<Game> gamesList = gameController.getAllGames();
            List<Game> userGames = new ArrayList<>();
            for(Owns owns : ownsList) {
                for(Game game : gamesList) {
                    if(owns.getG_id().equals(game.getId())) {
                        userGames.add(game);
                    }
                }
            }
            model.addAttribute("owns", userGames);
            List<Game> games = new ArrayList<>();
            for(Game game : gamesList) {
                if(!userGames.contains(game)) {
                    games.add(game);
                }
            }
            model.addAttribute("games", games);
            List<Package> pkgList = packageController.getAllPackages();
            model.addAttribute("pkgs", pkgList);
            return "usr_logged";
        } else {
            model.addAttribute("id", email);
            return "err_login";
        }
    }

    
    @Autowired
    private EmpLoginController empLoginController;

    @PostMapping("/empLogin")
    public String adminLogin(
        @RequestParam(value = "emp_id") String empId,
        Model model
    ) {
        EmpLogin emp = empLoginController.empLoginCaller(empId);
        if(emp != null) {
            model.addAttribute("emp", emp);
            List<Package> pkgList = packageController.getPerPlayerPackages();
            model.addAttribute("pkgs", pkgList);
            List<EmpLogin> empList = empLoginController.getAllEmpsUnderMgr(empId);
            model.addAttribute("manages", empList);
            List<Owns> ownsList = ownsController.getAllOwns();
            model.addAttribute("ownsList", ownsList);
            return "emp_logged";
        } else {
            model.addAttribute("id", empId);
            return "err_login";
        }
    }

    @RequestMapping(value = "/buyGame/{gameId}", method = RequestMethod.GET)
    public RedirectView buyGame(
        @PathVariable("gameId") String g,
        Model model,
        RedirectAttributes redirectAttributes
    ) {
        ownsController.addGameForPlayer(usr.p_email, g);
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/usrLogin");
        return redirectView;
    }

    @GetMapping("/delGame/{gameId}")
    public RedirectView deleteGame(
        @PathVariable("gameId") String g,
        Model model,
        RedirectAttributes redirectAttributes
    ) {
        ownsController.deleteGameForPlayer(usr.p_email, g);
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/usrLogin");
        return redirectView;
    }
}