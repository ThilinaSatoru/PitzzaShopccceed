package Nibm.lk.PitzzaShop.controller;


import Nibm.lk.PitzzaShop.MODEL.User;
import Nibm.lk.PitzzaShop.service.IUserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private final IUserservice userService;

    public LoginController(IUserservice userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String ShowLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String Login(@RequestParam String username, @RequestParam String password, Model model) {

        User user = userService.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            System.out.println("login complete");
            return "pizzas";
        }
        else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }


    }


}
