package uz.pdp.wearhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.wearhouse.entity.Client;
import uz.pdp.wearhouse.entity.Currency;
import uz.pdp.wearhouse.entity.Output;
import uz.pdp.wearhouse.entity.Wearhouse;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.payload.OutputDto;
import uz.pdp.wearhouse.repository.ClientRepository;
import uz.pdp.wearhouse.repository.CurrencyRepository;
import uz.pdp.wearhouse.repository.OutputRepository;
import uz.pdp.wearhouse.repository.WearhouseRepository;

import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    WearhouseRepository wearhouseRepository;

    public ApiResponse getAll(int page) {

        Pageable pageable = PageRequest.of(page,10);
        Page<Output> outputs = outputRepository.findAll(pageable);
        return new ApiResponse("OK!",true,outputs);
    }

    public ApiResponse get(Integer id) {

        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (optionalOutput.isPresent()){
            Output output = optionalOutput.get();
            return new ApiResponse("OK!",true,output);
        }
        return new ApiResponse("Bu Id lik output topilmadi!!!",false);
    }
    public String genereteCode(String name){
        String code = Random.random(name);
        boolean existsByCode = outputRepository.existsByCode(code);
        if (existsByCode){
            genereteCode(name);
        }
        return code;
    }

    public ApiResponse add(OutputDto outputDto) {
        Output output = new Output();
        String code = genereteCode("o");
        output.setCode(code);
        output.setFactureNumber(outputDto.getFactureNumber());
        Client client = clientRepository.getById(outputDto.getClientId());
        output.setClient(client);

        Currency currency = currencyRepository.getById(outputDto.getCurrencyId());
        output.setCurrency(currency);

        Wearhouse wearhouse = wearhouseRepository.getById(outputDto.getWearhouseId());
        output.setWearhouse(wearhouse);
        outputRepository.save(output);
        return new ApiResponse("Saqlandi!!!",true);

    }

    public ApiResponse edit(Integer id, OutputDto outputDto) {
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (optionalOutput.isPresent()){
            Output output = optionalOutput.get();
            String code = genereteCode("o");
            output.setCode(code);
            output.setFactureNumber(outputDto.getFactureNumber());
            Client client = clientRepository.getById(outputDto.getClientId());
            output.setClient(client);

            Currency currency = currencyRepository.getById(outputDto.getCurrencyId());
            output.setCurrency(currency);

            Wearhouse wearhouse = wearhouseRepository.getById(outputDto.getWearhouseId());
            output.setWearhouse(wearhouse);
            outputRepository.save(output);
            return new ApiResponse("O'zgartirildi!!!",true);

        }
        return new ApiResponse("Bunay ID lik output topilmadi!!!",false);

    }

    public ApiResponse delete(Integer id) {

        outputRepository.deleteById(id);
        return new ApiResponse("O'chirildi!!!",true);
    }
}
