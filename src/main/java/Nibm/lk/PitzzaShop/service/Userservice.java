package Nibm.lk.PitzzaShop.service;


import Nibm.lk.PitzzaShop.MODEL.User;
import Nibm.lk.PitzzaShop.repository.UserRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userservice  implements IUserservice{

@Autowired
    private static UserRepositery userRepositery;


    public static User findbyUsername(String username){return userRepositery.findbyUsername(username);}

    @Override
    public User findByUsenname(String username) {
        return userRepositery.findbyUsername(username);
    }
}
