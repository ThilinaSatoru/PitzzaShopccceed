package Nibm.lk.PitzzaShop.service;

import Nibm.lk.PitzzaShop.MODEL.User;

import java.util.Optional;

public interface IUserservice {
    Optional<User> findById(Long userId);

    User findByUsername(String username);
}
