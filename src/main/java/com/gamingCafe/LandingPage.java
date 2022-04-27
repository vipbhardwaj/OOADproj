package com.gamingCafe;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @PostMapping("/usrLogin")
    public String usrLogin(
        @RequestParam(value = "usr_email") String email,
        @RequestParam(value = "usr_pwd") String pwd,
        Model model
    ) {
        UsrLogin usr = usrLoginController.usrLoginCaller(email, pwd);
        if(usr != null) {
            model.addAttribute("usr", usr);
            List<String> oList = ownsController.getOwnsByUsr(email);
            model.addAttribute("oList", oList);
            List<Game> gamesList = gameController.getAllGames();
            model.addAttribute("games", gamesList);
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


    // @PostMapping("/buyGame")
    // public String buyGame(
    //     @RequestParam(value = "game") Game g,
    //     Model model
    // ) {
    //     gameController.buyGame(g);
    //     return "redirect:/usrLogin";

    // }
}