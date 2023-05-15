package Nibm.lk.PitzzaShop.controller;

import Nibm.lk.PitzzaShop.MODEL.Basket;
import Nibm.lk.PitzzaShop.service.IBusketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BusketController {

    @Autowired
    IBusketService service;

    @RequestMapping(value = "/basket",method = RequestMethod.POST)
    @ResponseBody
    public Basket createBasket(@RequestBody Basket basket){
        return service.save(basket);
    }
}
