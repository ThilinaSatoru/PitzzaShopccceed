package Nibm.lk.PitzzaShop.repository;

import Nibm.lk.PitzzaShop.MODEL.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
