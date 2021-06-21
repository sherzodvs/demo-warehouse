package uz.pdp.wearhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.wearhouse.entity.Supplier;
import uz.pdp.wearhouse.entity.Wearhouse;

public interface WearhouseRepository extends JpaRepository<Wearhouse, Integer> {
    boolean existsByName(String name);

}
