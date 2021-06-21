package uz.pdp.wearhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.wearhouse.entity.Attachmant;
import uz.pdp.wearhouse.entity.Measurment;

public interface MeasurmentRepository extends JpaRepository<Measurment, Integer> {
    boolean existsByName(String name);
}
