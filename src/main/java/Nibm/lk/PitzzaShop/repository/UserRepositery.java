package Nibm.lk.PitzzaShop.repository;

import Nibm.lk.PitzzaShop.MODEL.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositery extends JpaRepository<User,Long> {



}