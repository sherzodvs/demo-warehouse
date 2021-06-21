package uz.pdp.wearhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.wearhouse.entity.*;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.payload.InputDto;
import uz.pdp.wearhouse.payload.OutputDto;
import uz.pdp.wearhouse.repository.*;

import java.util.Optional;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    WearhouseRepository wearhouseRepository;

    public ApiResponse getAll(int page) {

        Pageable pageable = PageRequest.of(page,10);
        Page<Input> inputs = inputRepository.findAll(pageable);
        return new ApiResponse("OK!",true,inputs);
    }

    public ApiResponse get(Integer id) {

        Optional<Input> optionalInput = inputRepository.findById(id);
        if (optionalInput.isPresent()){
            Input input = optionalInput.get();
            return new ApiResponse("OK!",true,input);
        }
        return new ApiResponse("Bu Id lik output topilmadi!!!",false);
    }
    public String genereteCode(String name){
        String code = Random.random(name);
        boolean existsByCode = inputRepository.existsByCode(code);
        if (existsByCode){
            genereteCode(name);
        }
        return code;
    }

    public ApiResponse add(InputDto inputDto) {
        Input input = new Input();
        String code = genereteCode("o");
        input.setCode(code);
        input.setFactureNumber(inputDto.getFactureNumber());


        Supplier supplier = supplierRepository.getById(inputDto.getSupplierId());
        input.setSupplier(supplier);

        Currency currency = currencyRepository.getById(inputDto.getCurrencyId());
        input.setCurrency(currency);

        Wearhouse wearhouse = wearhouseRepository.getById(inputDto.getWearhouseId());
        input.setWearhouse(wearhouse);

        inputRepository.save(input);
        return new ApiResponse("Saqlandi!!!",true);

    }

    public ApiResponse edit(Integer id, InputDto inputDto) {
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (optionalInput.isPresent()){
            Input input = optionalInput.get();
            String code = genereteCode("o");
            input.setCode(code);
            input.setFactureNumber(inputDto.getFactureNumber());


            Supplier supplier = supplierRepository.getById(inputDto.getSupplierId());
            input.setSupplier(supplier);

            Currency currency = currencyRepository.getById(inputDto.getCurrencyId());
            input.setCurrency(currency);

            Wearhouse wearhouse = wearhouseRepository.getById(inputDto.getWearhouseId());
            input.setWearhouse(wearhouse);

            inputRepository.save(input);
            return new ApiResponse("O'zgartirildi!!!",true);

        }
        return new ApiResponse("Bunay ID lik output topilmadi!!!",false);

    }

    public ApiResponse delete(Integer id) {

        inputRepository.deleteById(id);
        return new ApiResponse("O'chirildi!!!",true);
    }
}
