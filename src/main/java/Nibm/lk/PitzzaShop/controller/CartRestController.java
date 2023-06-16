package Nibm.lk.PitzzaShop.controller;

import Nibm.lk.PitzzaShop.MODEL.Cart;
import Nibm.lk.PitzzaShop.MODEL.DTO.CartItemDTO;
import Nibm.lk.PitzzaShop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CartRestController {

    @Autowired
    ICartService cartService;


    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    @ResponseBody
    public List<Cart> getCarts() {
        return cartService.findAll();
    }

    @PostMapping("/cart")
    public List<CartItemDTO> createBasket(@RequestBody List<CartItemDTO> cartItems) {
        return cartService.saveAll(cartItems);
    }

    @RequestMapping(value = "/basket/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteBasket(@PathVariable Long id) {
        return cartService.delete(id);
    }
}
