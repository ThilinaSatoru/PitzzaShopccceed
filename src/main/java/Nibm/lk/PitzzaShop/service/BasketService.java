package Nibm.lk.PitzzaShop.service;

import Nibm.lk.PitzzaShop.MODEL.Basket;
import Nibm.lk.PitzzaShop.repository.BusketRepositery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BasketService implements IBusketService {

    @Autowired
    BusketRepositery basketRepository;


    @Override
    public Basket save(Basket basket) {
        Basket dto = null;
        if (basket.getId() == null) {
            dto = new Basket();
        } else {
            Optional<Basket> optionalBasket = basketRepository.findById(basket.getId());
            if (optionalBasket.isPresent()) {
                dto = optionalBasket.get();
            }
        }
        BeanUtils.copyProperties(basket, dto);
        dto = basketRepository.save(dto);
        basket.setId(dto.getId());
        return basket;
    }
}
