package uz.pdp.wearhouse.conreoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.wearhouse.entity.Category;
import uz.pdp.wearhouse.payload.ApiResponse;
import uz.pdp.wearhouse.payload.CategoryDto;
import uz.pdp.wearhouse.repository.CategoryRepository;
import uz.pdp.wearhouse.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ApiResponse getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        return categoryService.getById(id);
    }

    @GetMapping("/byparenCategoryId/{parentCategoryId}")
    public ApiResponse getByParentCategoryId(@PathVariable Integer parentCategoryId){
        return categoryService.getByParentCategoryId(parentCategoryId);
    }

    @PostMapping
    public ApiResponse add(@RequestBody CategoryDto categoryDto){
       return categoryService.add(categoryDto);
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody CategoryDto categoryDto){
        return categoryService.edit(id,categoryDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return categoryService.delete(id);
    }
}
