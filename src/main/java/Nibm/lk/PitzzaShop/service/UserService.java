package Nibm.lk.PitzzaShop.service;


import Nibm.lk.PitzzaShop.MODEL.User;
import Nibm.lk.PitzzaShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService  implements IUserservice{

    @Autowired
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Optional<User> findById(Long userid) {
        return userRepo.findById(userid);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }


}
