package uz.pdp.wearhouse.conreoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.wearhouse.entity.Currency;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.service.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrenyController {
    @Autowired
    CurrencyService currencyService;

    @GetMapping
    public ApiResponse getAll(){
        return currencyService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        return currencyService.getById(id);
    }

    @PostMapping
    public ApiResponse add(@RequestBody Currency currency){
        return currencyService.add(currency);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody Currency currency){
        return currencyService.edit(id,currency);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return currencyService.delete(id);
    }
}
