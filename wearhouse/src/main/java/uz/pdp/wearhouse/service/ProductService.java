package uz.pdp.wearhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.wearhouse.entity.Attachmant;
import uz.pdp.wearhouse.entity.Category;
import uz.pdp.wearhouse.entity.Measurment;
import uz.pdp.wearhouse.entity.Product;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.payload.ProductDto;
import uz.pdp.wearhouse.repository.AttachmantRepository;
import uz.pdp.wearhouse.repository.CategoryRepository;
import uz.pdp.wearhouse.repository.MeasurmentRepository;
import uz.pdp.wearhouse.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    AttachmantRepository attachmantRepository;

    @Autowired
    MeasurmentRepository measurmentRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse getAll(int page) {
        Pageable pageable = PageRequest.of(page,10);
        Page<Product> products = productRepository.findAll(pageable);
        return new ApiResponse("OK!",true,products);
    }


    public ApiResponse getById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            return new ApiResponse("OK!",true,product);
        }
        return new ApiResponse("Bunday id lik product topilmadi!!!",false);
    }

    public String genered(String name){
        String code = Random.random(name);
        boolean existsByCode = productRepository.existsByCode(code);
        if (existsByCode){
            genered(name);
        }
        return code;
    }
    public ApiResponse add(ProductDto productDto) {
        Product product = new Product();

        Attachmant photo = attachmantRepository.getById(productDto.getPhotoId());
        product.setPhoto(photo);

        Measurment measurment = measurmentRepository.getById(productDto.getMeasurmentId());
        product.setMeasurment(measurment);

        Category category = categoryRepository.getById(productDto.getCategoryId());
        product.setCategory(category);

        String code = genered("p");

        product.setName(productDto.getName());
        product.setActive(productDto.isActive());
        product.setCode(code);

        productRepository.save(product);
        return new ApiResponse("Saqlandi!!!",true);
    }

    public ApiResponse edit(Integer id, ProductDto productDto) {
        Product product = productRepository.getById(id);
        Attachmant photo = attachmantRepository.getById(productDto.getPhotoId());
        product.setPhoto(photo);

        Measurment measurment = measurmentRepository.getById(productDto.getMeasurmentId());
        product.setMeasurment(measurment);

        Category category = categoryRepository.getById(productDto.getCategoryId());
        product.setCategory(category);

        String code = genered("p");

        product.setName(productDto.getName());
        product.setActive(productDto.isActive());
        product.setCode(code);

        productRepository.save(product);
        return new ApiResponse("O'zgardi!!!",true);

    }

    public ApiResponse delete(Integer id) {
        productRepository.deleteById(id);
        return new ApiResponse("Product o'chirildi!!!", true);
    }
}
