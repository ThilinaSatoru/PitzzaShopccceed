package Nibm.lk.PitzzaShop.controller;


import Nibm.lk.PitzzaShop.MODEL.User;
import Nibm.lk.PitzzaShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userservice;
    @GetMapping("/")
    public String Showloginpage(){ return "Loggin";}

    @PostMapping("/Loggin")
    public String Loggin(@RequestParam long useId, @RequestParam String password, Model model ){

        User user=userservice.findById(useId);

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