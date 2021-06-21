package uz.pdp.wearhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.wearhouse.entity.Category;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.payload.CategoryDto;
import uz.pdp.wearhouse.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse getAll() {
        List<Category> categories = categoryRepository.findAll();
        return new ApiResponse("OK!", true, categories);
    }


    public ApiResponse getById(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            return new ApiResponse("OK!", true, category);
        }
        return new ApiResponse("Bunday id lik category topilmadi!!!", false);
    }

    public ApiResponse getByParentCategoryId(Integer parentCategoryId) {

        List<Category> categories = categoryRepository.findByParentCategoryId(parentCategoryId);
        return new ApiResponse("OK!",true,categories);
    }

    public ApiResponse add(CategoryDto categoryDto) {

        Category category = new Category();
        category.setActive(categoryDto.isActive());
        category.setName(categoryDto.getName());
        Category categoryParent = new Category();
        if (categoryDto.getParentCategoryId() !=null){
            categoryParent = categoryRepository.getById(categoryDto.getParentCategoryId());
        }
        category.setParentCategory(categoryParent);
        return new ApiResponse("Saqlandi!!!",true);
    }

    public ApiResponse edit(Integer id, CategoryDto categoryDto) {
        Category category = categoryRepository.getById(id);
        category.setActive(categoryDto.isActive());
        category.setName(categoryDto.getName());
        Category categoryParent = new Category();
        if (categoryDto.getParentCategoryId() !=null){
            categoryParent = categoryRepository.getById(categoryDto.getParentCategoryId());
        }
        category.setParentCategory(categoryParent);
        return new ApiResponse("O'zgartirildi!!!",true);
    }

    public ApiResponse delete(Integer id) {

        categoryRepository.deleteById(id);
        return new ApiResponse("Categporiya o'chirildi",true);
    }
}
