package Nibm.lk.PitzzaShop.controller;


import Nibm.lk.PitzzaShop.MODEL.User;
import Nibm.lk.PitzzaShop.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserLoggingController {

    @Autowired
    private Userservice userservice;
    @GetMapping("/")
    public String Showloginpage(){ return "Loggin";}

    @PostMapping("/Loggin")
    public String Loggin(@RequestParam String username, @RequestParam String password, Model model ){

        User user=userservice.findByUsenname(username);

        if (user != null && user.getPassword().equals(password)) {
            System.out.println("login complete");
            return "pizzas";
        }
        else {
            model.addAttribute("error", "Invalid username or password");
            return  "Loggin";
        }


    }


}
