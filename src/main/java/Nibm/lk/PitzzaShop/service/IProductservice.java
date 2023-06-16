package Nibm.lk.PitzzaShop.service;

import Nibm.lk.PitzzaShop.MODEL.Product;

import java.util.List;

public interface IProductservice {
    List<Product> findAll();

    Product save(Product product);

    Product find(Long id);

    boolean delete(Long id);


}
