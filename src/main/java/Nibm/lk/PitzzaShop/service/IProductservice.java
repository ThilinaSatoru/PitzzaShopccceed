package Nibm.lk.PitzzaShop.service;

import Nibm.lk.PitzzaShop.MODEL.Products;

import java.util.List;

public interface IProductservice {
    List<Products> findAll();

    Products save(Products product);

    Products find(Long id);

    boolean delete(Long id);


}
