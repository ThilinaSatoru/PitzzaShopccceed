package Nibm.lk.PitzzaShop.service;

import Nibm.lk.PitzzaShop.MODEL.Cart;
import Nibm.lk.PitzzaShop.MODEL.CartItem;
import Nibm.lk.PitzzaShop.MODEL.DTO.CartItemDTO;
import Nibm.lk.PitzzaShop.MODEL.Product;
import Nibm.lk.PitzzaShop.repository.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    IProductservice productservice;

    @Override
    public Cart save(Cart cart) {
        Cart dto = null;
        if (cart.getId() == null) {
            dto = new Cart();
        } else {
            Optional<Cart> optionalBasket = cartRepository.findById(cart.getId());
            if (optionalBasket.isPresent()) {
                dto = optionalBasket.get();
            }
        }
        assert dto != null;
        BeanUtils.copyProperties(cart, dto);
        dto = cartRepository.save(dto);
        cart.setId(dto.getId());
        return cart;
    }

    @Override
    @Transactional
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    @Transactional
    public List<CartItemDTO> saveAll(List<CartItemDTO> cartItems) {

        List<CartItem> cartItemList = new ArrayList<>();

        Cart cart = Cart.builder()
                .cartItems(cartItemList)
                .status("ADDED")
                .build();

        cartItems.forEach(cartItem -> {
            if (cartItem.getProduct() != null) {
                Product product = productservice.find(cartItem.getProduct());
                CartItem item = CartItem.builder()
                        .product(product)
                        .quantity(cartItem.getQuantity())
                        .cart(cart)
                        .price(cartItem.getQuantity() * product.getPrice())
                        .build();
                cartItemList.add(item);
            }
        });


        if (!cartItemList.isEmpty()) {
            cart.setAmount(cartItemList.stream().mapToDouble(CartItem::getPrice).sum());
            cartRepository.save(cart);
        }
        return cartItems;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if (cart.isPresent()) {
            cartRepository.delete(cart.get());
        } else {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
