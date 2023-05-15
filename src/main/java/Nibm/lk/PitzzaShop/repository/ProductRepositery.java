package Nibm.lk.PitzzaShop.repository;

import Nibm.lk.PitzzaShop.MODEL.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositery extends JpaRepository<Products,Long> {


}
