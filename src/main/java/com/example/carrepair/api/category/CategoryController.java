package com.example.carrepair.api.category;

import com.example.carrepair.model.category.CategoryService;
import com.example.carrepair.model.category.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAll() {
        return categoryService.findAll();
    }

    @GetMapping("/names")
    public List<String> findAllNames(){
        return categoryService.findALlNames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public void createCategory(@RequestBody CategoryDto category){
         categoryService.saveCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.removeCategory(id);
    }

}
