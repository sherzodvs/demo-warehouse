package uz.pdp.wearhouse.conreoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.payload.InputProductDto;
import uz.pdp.wearhouse.payload.OutputProductDto;
import uz.pdp.wearhouse.service.InputProductService;
import uz.pdp.wearhouse.service.InputService;
import uz.pdp.wearhouse.service.OutputProductService;

@RestController
@RequestMapping("/imputproduct")
public class InputProductController {
    @Autowired
    InputProductService inputProductService;


    @GetMapping
    public ApiResponse getAll(){
        return inputProductService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        return inputProductService.getById(id);
    }

    @PostMapping
    public ApiResponse add(@RequestBody InputProductDto inputProductDto){
       return inputProductService.add(inputProductDto);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody InputProductDto inputProductDto){
        return inputProductService.edit(id,inputProductDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return inputProductService.delete(id);
    }
}
