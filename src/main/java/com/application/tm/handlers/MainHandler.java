package com.application.tm.handlers;

import com.application.tm.database.DataBase;
import com.application.tm.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

@Controller
public class MainHandler {

    private final DataBase db = new DataBase();

    public MainHandler() throws SQLException, IOException, ClassNotFoundException {
    }

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
            return user.getUUID();
        }
        return null;
    }

//    @GetMapping("/{username}")
//    public void username(@PathVariable String username){
//        System.out.println(username);
//    }

    @GetMapping("/redirect")
    public ModelAndView redirect(){
        return new ModelAndView("redirect:" + "/");
    }
}
