package Nibm.lk.PitzzaShop.repository;

import Nibm.lk.PitzzaShop.MODEL.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositery extends JpaRepository<User,Long> {

    User findbyUsername(String username);
}
