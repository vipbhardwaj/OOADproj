package com.gamingCafe.Landing;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LandingPage {

  @GetMapping("/")
  public String greetingForm(Model model) {
    model.addAttribute("login", new Login());
    return "index";
  }

  @PostMapping("/login")
  public String greetingSubmit(@ModelAttribute Login login, Model model) {
    model.addAttribute("login", login);
    return "logged";
  }

}