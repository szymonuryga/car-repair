package com.example.carrepair.model.category;

import com.example.carrepair.model.category.dto.CategoryDto;
import com.example.carrepair.model.category.dto.CategoryMapper;
import com.example.carrepair.model.client.Client;
import com.example.carrepair.model.client.DuplicateNationalIdException;
import com.example.carrepair.model.client.dto.ClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    CategoryMapper categoryMapper = new CategoryMapper();

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<CategoryDto> findById(Long id) {
        return categoryRepository.findById(id).map(CategoryMapper::toDto);
    }

    public void removeCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public CategoryDto saveCategory(CategoryDto category) {
        Optional<Category> categoryByName = categoryRepository.findByName(category.getName());
        categoryByName.ifPresent(a ->{
            throw new DuplicateNameCategoryException();
        });
        Category categoryEntity = categoryMapper.toEntity(category);
        Category savedCategory = categoryRepository.save(categoryEntity);
        return categoryMapper.toDto(savedCategory);
    }

    public List<String> findALlNames() {
        return categoryRepository.findAll()
                .stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }
}
