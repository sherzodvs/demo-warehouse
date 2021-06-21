package uz.pdp.wearhouse.conreoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.payload.OutputDto;
import uz.pdp.wearhouse.service.OutputService;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;

    @GetMapping
    public ApiResponse getAll(@RequestParam int page){
        return outputService.getAll(page);

    }

    @GetMapping("/{id}")
    public ApiResponse get(@PathVariable Integer id){
        return outputService.get(id);
    }

    @PostMapping
    public ApiResponse add(@RequestBody OutputDto outputDto){
        return outputService.add(outputDto);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody OutputDto outputDto){
        return outputService.edit(id,outputDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return outputService.delete(id);
    }
}
