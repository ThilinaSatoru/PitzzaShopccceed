package Nibm.lk.PitzzaShop.service;

import Nibm.lk.PitzzaShop.MODEL.Cart;
import Nibm.lk.PitzzaShop.MODEL.DTO.CartItemDTO;

import java.util.List;

public interface ICartService {
    Cart save(Cart cart);

    List<Cart> findAll();

    List<CartItemDTO> saveAll(List<CartItemDTO> cartItems);

    boolean delete(Long id);

}
