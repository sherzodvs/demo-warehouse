package uz.pdp.wearhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.wearhouse.entity.Output;

import javax.persistence.criteria.CriteriaBuilder;

public interface OutputRepository extends JpaRepository<Output, Integer> {
    boolean existsByCode(String code);
}
