package uz.pdp.wearhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.wearhouse.entity.Input;
import uz.pdp.wearhouse.entity.Output;

public interface InputRepository extends JpaRepository<Input, Integer> {
    boolean existsByCode(String code);
}
