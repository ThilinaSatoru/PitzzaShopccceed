package Nibm.lk.PitzzaShop.service;

import Nibm.lk.PitzzaShop.MODEL.Product;
import Nibm.lk.PitzzaShop.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ProductsService implements IProductservice {


    @Autowired
    ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        Product dto = null;
        if (product.getId() == null) {
            dto = new Product();
        } else {
            Optional<Product> optionalProducts = productRepository.findById(product.getId());
            if (optionalProducts.isPresent()) {
                dto = optionalProducts.get();
            }
        }
        BeanUtils.copyProperties(product, dto);
        dto = productRepository.save(dto);
        product.setId(dto.getId());
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(s -> {
            Product dto = new Product();
            BeanUtils.copyProperties(s, dto);
            return dto;
        }).collect(Collectors.toList());
    }


    @Override
    public Product find(Long id) {
        Optional<Product> optionalProducts = productRepository.findById(id);
        if (optionalProducts.isPresent()) {
            Product dto = new Product();
            BeanUtils.copyProperties(optionalProducts.get(), dto);
            return dto;
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            productRepository.delete(optionalProduct.get());
        } else {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product get(long id) {
        return productRepository.findById(id).get();
    }

    public void deleteProducts(long id) {
        productRepository.deleteById(id);
    }

    public void saveProducts(Product std) {
        productRepository.save(std);
    }


}
