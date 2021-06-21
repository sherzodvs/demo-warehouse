package uz.pdp.wearhouse.conreoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.wearhouse.entity.Measurment;
import uz.pdp.wearhouse.entity.Wearhouse;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.service.WearhouseService;

@RestController
@RequestMapping("/wearhouse")
public class WeahouseController {

    @Autowired
    WearhouseService wearhouseService;

    @GetMapping
    public ApiResponse getAll(){
        return wearhouseService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        return wearhouseService.getById(id);
    }

    @PostMapping
    public ApiResponse add(@RequestBody Wearhouse wearhouse){
        return wearhouseService.add(wearhouse);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody Wearhouse wearhouse){
        return wearhouseService.edit(id,wearhouse);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return wearhouseService.delete(id);
    }

}
