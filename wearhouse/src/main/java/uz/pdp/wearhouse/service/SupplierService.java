package uz.pdp.wearhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.wearhouse.entity.Supplier;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public ApiResponse getAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return new ApiResponse("Ok!", true,suppliers);

    }

    public ApiResponse getById(Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()){
            Supplier supplier = optionalSupplier.get();
            return new ApiResponse("OK!",true,supplier);
        }

        return new ApiResponse("Bunday idilik Spplier topilmadi!!!",false);
    }

    public ApiResponse add(Supplier supplier) {

        Supplier supplierNew = new Supplier();
        supplierNew.setName(supplier.getName());
        supplierNew.setPhoneNumber(supplier.getPhoneNumber());
        supplierRepository.save(supplierNew);
        return new ApiResponse("Saqlandi!!!",true);
    }

    public ApiResponse edit(Integer id, Supplier supplier) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (supplierOptional.isPresent()){
            Supplier supplierNew = supplierOptional.get();
            supplierNew.setName(supplier.getName());
            supplierNew.setPhoneNumber(supplier.getPhoneNumber());
            supplierRepository.save(supplierNew);
            return new ApiResponse("Saqlandi!!!",true);
        }
        return new ApiResponse("Bunday idilik Spplier topilmadi!!!",false);
    }

    public ApiResponse delete(Integer id) {
        supplierRepository.deleteById(id);
        return new ApiResponse("O'chirildi!!!",true);
    }
}
