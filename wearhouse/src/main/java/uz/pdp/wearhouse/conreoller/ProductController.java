package uz.pdp.wearhouse.conreoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.payload.ProductDto;
import uz.pdp.wearhouse.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;



    @GetMapping
    public ApiResponse getAll(@RequestParam int page){
        return productService.getAll(page);
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        return productService.getById(id);
    }

    @PostMapping
    public ApiResponse add(@RequestBody ProductDto productDto){
        return productService.add(productDto);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody ProductDto productDto){
        return productService.edit(id,productDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return productService.delete(id);
    }
}
