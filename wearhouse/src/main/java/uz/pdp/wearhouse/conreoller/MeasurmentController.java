package uz.pdp.wearhouse.conreoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.wearhouse.entity.Measurment;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.service.MeasurmentService;

import java.util.List;

@RestController
@RequestMapping("/measurment")
public class MeasurmentController {
    @Autowired
    MeasurmentService measurmentService;

    @GetMapping
    public ApiResponse getAll(){
        return measurmentService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        return measurmentService.getById(id);
    }

    @PostMapping
    public ApiResponse add(@RequestBody Measurment measurment){
        return measurmentService.add(measurment);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody Measurment measurment){
        return measurmentService.edit(id,measurment);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return measurmentService.delete(id);
    }


}
