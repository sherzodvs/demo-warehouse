package uz.pdp.wearhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.wearhouse.entity.*;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.payload.InputProductDto;
import uz.pdp.wearhouse.payload.OutputProductDto;
import uz.pdp.wearhouse.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {
    @Autowired
    InputPoductRepository inputPoductRepository;


    @Autowired
    ProductRepository productRepository;

    @Autowired
    InputRepository inputRepository;

    public ApiResponse getAll() {
        List<InputProduct> productList = inputPoductRepository.findAll();
        return new ApiResponse("OK!",true,productList);
    }

    public ApiResponse getById(Integer id) {
        Optional<InputProduct> optionalInputProduct = inputPoductRepository.findById(id);
        if (optionalInputProduct.isPresent()){
            InputProduct inputProduct = optionalInputProduct.get();
            return new ApiResponse("OK!", true,inputProduct);
        }

        return new ApiResponse("Bunday ID topilmadi",false);
    }

    public ApiResponse add(InputProductDto inputProductDto) {
        InputProduct inputProduct = new InputProduct();
        inputProduct.setAmmount(inputProductDto.getAmmount());
        inputProduct.setPrice(inputProductDto.getPrice());

        Input input = inputRepository.getById(inputProductDto.getInputId());
        inputProduct.setInput(input);

        Product product = productRepository.getById(inputProductDto.getProductId());
        inputProduct.setProduct(product);

        inputProduct.setExpireDate(inputProductDto.getExpireDate());

        inputPoductRepository.save(inputProduct);
        return new ApiResponse("Saqlandi!!!",true);
    }

    public ApiResponse edit(Integer id, InputProductDto inputProductDto) {
        Optional<InputProduct> optionalInputProduct = inputPoductRepository.findById(id);
        if (optionalInputProduct.isPresent()){
            InputProduct inputProduct = optionalInputProduct.get();
            inputProduct.setAmmount(inputProductDto.getAmmount());
            inputProduct.setPrice(inputProductDto.getPrice());

            Input input = inputRepository.getById(inputProductDto.getInputId());
            inputProduct.setInput(input);

            Product product = productRepository.getById(inputProductDto.getProductId());
            inputProduct.setProduct(product);

            inputProduct.setExpireDate(inputProductDto.getExpireDate());

            inputPoductRepository.save(inputProduct);
            return new ApiResponse("O'zgartirildi!!!",true);
        }
        return new ApiResponse("Id topilmadi!!!",false);
    }

    public ApiResponse delete(Integer id) {

        inputPoductRepository.deleteById(id);
        return new ApiResponse("O'chirildi!!!",true);
    }
}
