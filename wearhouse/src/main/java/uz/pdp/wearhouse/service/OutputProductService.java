package uz.pdp.wearhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.wearhouse.entity.Output;
import uz.pdp.wearhouse.entity.OutputProduct;
import uz.pdp.wearhouse.entity.Product;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.payload.OutputProductDto;
import uz.pdp.wearhouse.repository.OutputPoductRepository;
import uz.pdp.wearhouse.repository.OutputRepository;
import uz.pdp.wearhouse.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {
    @Autowired
    OutputPoductRepository outputPoductRepository;


    @Autowired
    ProductRepository productRepository;

    @Autowired
    OutputRepository outputRepository;

    public ApiResponse getAll() {
        List<OutputProduct> productList = outputPoductRepository.findAll();
        return new ApiResponse("OK!",true,productList);
    }

    public ApiResponse getById(Integer id) {
        Optional<OutputProduct> optionalOutputProduct = outputPoductRepository.findById(id);
        if (optionalOutputProduct.isPresent()){
            OutputProduct outputProduct = optionalOutputProduct.get();
            return new ApiResponse("OK!", true,outputProduct);
        }

        return new ApiResponse("Bunday ID topilmadi",false);
    }

    public ApiResponse add(OutputProductDto outputProductDto) {
        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setAmmount(outputProductDto.getAmmount());
        outputProduct.setPrice(outputProductDto.getPrice());

        Output output = outputRepository.getById(outputProductDto.getOutputId());
        outputProduct.setOutput(output);

        Product product = productRepository.getById(outputProductDto.getProductId());
        outputProduct.setProduct(product);

        outputPoductRepository.save(outputProduct);
        return new ApiResponse("Saqlandi!!!",true);
    }

    public ApiResponse edit(Integer id, OutputProductDto outputProductDto) {
        Optional<OutputProduct> optionalOutputProduct = outputPoductRepository.findById(id);
        if (optionalOutputProduct.isPresent()){
            OutputProduct outputProduct = optionalOutputProduct.get();
            outputProduct.setAmmount(outputProductDto.getAmmount());
            outputProduct.setPrice(outputProductDto.getPrice());

            Output output = outputRepository.getById(outputProductDto.getOutputId());
            outputProduct.setOutput(output);

            Product product = productRepository.getById(outputProductDto.getProductId());
            outputProduct.setProduct(product);

            outputPoductRepository.save(outputProduct);
            return new ApiResponse("O'zgartirildi!!!",true);
        }
        return new ApiResponse("Id topilmadi!!!",false);
    }

    public ApiResponse delete(Integer id) {

        outputPoductRepository.deleteById(id);
        return new ApiResponse("O'chirildi!!!",true);
    }
}
