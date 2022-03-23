package com.application.tm.handlers;

import com.application.tm.database.DataBase;
import com.application.tm.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@Controller
public class MainHandler {

    private final DataBase db = new DataBase();

    public MainHandler() throws SQLException, IOException, ClassNotFoundException { }

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
    public UUID signUp(@RequestParam String username, @RequestParam String password) throws SQLException, IOException, ClassNotFoundException {
        System.out.println(username + " : " + password);
        if (!db.isExist(username)){
            User user = new User(username, password);
            db.addUser(user);
            return user.getUUID();
        }
        return null;
    }

    @GetMapping("/{username}")
    public String username(@PathVariable String username, Model model){
        return "user";
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ModelAndView returnUserPage(@RequestParam String uid){
        return new ModelAndView("redirect:" + "/" + uid);
    }

    @GetMapping("/redirect")
    public ModelAndView redirect(){
        return new ModelAndView("redirect:" + "/");
    }
}
