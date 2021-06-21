package uz.pdp.wearhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.wearhouse.entity.Client;
import uz.pdp.wearhouse.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
