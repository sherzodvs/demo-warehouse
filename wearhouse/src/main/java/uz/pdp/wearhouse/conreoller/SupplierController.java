package uz.pdp.wearhouse.conreoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.wearhouse.entity.Supplier;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping
    public ApiResponse getAll(){
        return supplierService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        return supplierService.getById(id);
    }

    @PostMapping
    public ApiResponse add(@RequestBody Supplier supplier){
        return supplierService.add(supplier);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody Supplier supplier){
        return supplierService.edit(id,supplier);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return  supplierService.delete(id);
    }
}
