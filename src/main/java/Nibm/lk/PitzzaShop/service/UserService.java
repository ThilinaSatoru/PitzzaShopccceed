package Nibm.lk.PitzzaShop.service;


import Nibm.lk.PitzzaShop.MODEL.User;
import Nibm.lk.PitzzaShop.repository.UserRepositery;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  implements IUserservice{

@Autowired
    private UserRepositery userRepo;
    ModelMapper mapper = new ModelMapper();

    @Override
    public User findById(Long userid) {
        return this.mapper.map(userRepo.findById(userid), User.class);
    }
}
