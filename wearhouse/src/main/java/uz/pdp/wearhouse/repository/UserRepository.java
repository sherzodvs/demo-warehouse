package uz.pdp.wearhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.wearhouse.entity.User;
import uz.pdp.wearhouse.entity.Wearhouse;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByCode(String code);

}
