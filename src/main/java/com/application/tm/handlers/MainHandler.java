package com.application.tm.handlers;

import com.application.tm.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class MainHandler {

    @GetMapping("/")
    public String mainPage(Model model){
        return "main";
    }

    @GetMapping("/signup")
    public String sighupPage(Model model){
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseBody
    public UUID signUp(@RequestParam String username, @RequestParam String password){
        System.out.println(username + " : " + password);
        User user = new User(username, password);
        System.out.println(user.getUuid());
        return user.getUuid();
    }

    @GetMapping("/{username}")
    public void username(@PathVariable String username){
        System.out.println(username);
    }

    @GetMapping("/redirect")
    public ModelAndView redirect(){
        return new ModelAndView("redirect:" + "/");
    }
}
