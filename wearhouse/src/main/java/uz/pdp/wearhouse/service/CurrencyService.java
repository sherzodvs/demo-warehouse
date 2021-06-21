package uz.pdp.wearhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.wearhouse.entity.Currency;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public ApiResponse getAll() {

        List<Currency> currencies = currencyRepository.findAll();
        return new ApiResponse("OK!",true,currencies);
    }

    public ApiResponse getById(Integer id) {
        Optional<Currency> currencyOptional = currencyRepository.findById(id);
        if (currencyOptional.isPresent()){
            Currency currency = currencyOptional.get();
            return new ApiResponse("OK!",true,currency);
        }
        return new ApiResponse("Bunaqa idlik currency topilmadi!!!",false);
    }

    public ApiResponse add(Currency currency) {
        Currency currencyNew = new Currency();
        currencyNew.setName(currency.getName());
        currencyNew.setActive(currency.isActive());
        currencyRepository.save(currencyNew);
        return new ApiResponse("Saqlandi!!!",true);
    }

    public ApiResponse edit(Integer id, Currency currency) {
        Optional<Currency> currencyOptional = currencyRepository.findById(id);
        if (currencyOptional.isPresent()){
            Currency currencyNew = currencyOptional.get();
            currencyNew.setName(currency.getName());
            currencyNew.setActive(currency.isActive());
            currencyRepository.save(currencyNew);
            return new ApiResponse("O'zgardi!!!",true);
        }
        return new ApiResponse("Bunaqa idlik currency topilmadi!!!",false);
    }

    public ApiResponse delete(Integer id) {

        currencyRepository.deleteById(id);
        return new ApiResponse("O'chirildi!!!",false);
    }
}
