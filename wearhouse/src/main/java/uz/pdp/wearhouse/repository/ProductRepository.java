package uz.pdp.wearhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.wearhouse.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByCode(String code);
}
