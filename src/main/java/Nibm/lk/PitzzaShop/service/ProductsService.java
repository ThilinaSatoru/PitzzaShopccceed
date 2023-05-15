package Nibm.lk.PitzzaShop.service;

import Nibm.lk.PitzzaShop.MODEL.Products;
import Nibm.lk.PitzzaShop.repository.ProductRepositery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductsService implements IProductservice {



    @Autowired
    ProductRepositery productRepositery;

    @Override
    public Products save(Products product) {
        Products dto = null;
        if(product.getId() == null){
            dto = new Products();
        }else{
            Optional<Products> optionalProducts = productRepositery.findById(product.getId());
            if(optionalProducts.isPresent()){
                dto = optionalProducts.get();
            }
        }
        BeanUtils.copyProperties(product,dto);
        dto = productRepositery.save(dto);
        product.setId(dto.getId());
        return product;
    }

    @Override
    public List<Products> findAll() {
        List<Products> products = productRepositery.findAll();
        return products.stream().map(s ->{
            Products dto = new Products();
            BeanUtils.copyProperties(s,dto);
            return dto;
        }).collect(Collectors.toList());
    }


    @Override
    public Products find(Long id) {
        Optional<Products> optionalProducts = productRepositery.findById(id);
        if(optionalProducts.isPresent()){
            Products dto = new Products();
            BeanUtils.copyProperties(optionalProducts.get(),dto);
            return dto;
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Products> optionalProduct = productRepositery.findById(id);
        if (optionalProduct.isPresent()) {
            productRepositery.delete(optionalProduct.get());
        }else {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public List<Products> listAll() {
        return productRepositery.findAll();
    }

    public Products get(long id) {
        return productRepositery.findById(id).get();
    }

    public void deleteProducts(long id) {
        productRepositery.deleteById(id);
    }

    public void saveProducts(Products std) {productRepositery.save(std);
    }


}
