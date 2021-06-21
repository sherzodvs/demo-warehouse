package uz.pdp.wearhouse.conreoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.wearhouse.entity.Output;
import uz.pdp.wearhouse.entity.OutputProduct;
import uz.pdp.wearhouse.entity.Product;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.payload.OutputProductDto;
import uz.pdp.wearhouse.repository.OutputRepository;
import uz.pdp.wearhouse.repository.ProductRepository;
import uz.pdp.wearhouse.service.OutputProductService;

@RestController
@RequestMapping("/outputproduct")
public class OutputProductController {
    @Autowired
    OutputProductService outputProductService;


    @GetMapping
    public ApiResponse getAll(){
        return outputProductService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        return outputProductService.getById(id);
    }

    @PostMapping
    public ApiResponse add(@RequestBody OutputProductDto outputProductDto){
       return outputProductService.add(outputProductDto);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody OutputProductDto outputProductDto){
        return outputProductService.edit(id,outputProductDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return outputProductService.delete(id);
    }
}
