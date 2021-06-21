package uz.pdp.wearhouse.conreoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.payload.InputDto;
import uz.pdp.wearhouse.payload.OutputDto;
import uz.pdp.wearhouse.service.InputService;
import uz.pdp.wearhouse.service.OutputService;

@RestController
@RequestMapping("/input")
public class InputController {
    @Autowired
    InputService inputService;

    @GetMapping
    public ApiResponse getAll(@RequestParam int page){
        return inputService.getAll(page);

    }

    @GetMapping("/{id}")
    public ApiResponse get(@PathVariable Integer id){
        return inputService.get(id);
    }

    @PostMapping
    public ApiResponse add(@RequestBody InputDto inputDto){
        return inputService.add(inputDto);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody InputDto inputDto){
        return inputService.edit(id,inputDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return inputService.delete(id);
    }
}
