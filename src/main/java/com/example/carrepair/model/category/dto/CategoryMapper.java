package com.example.carrepair.model.category.dto;

import com.example.carrepair.model.category.Category;

public class CategoryMapper {

    public static CategoryDto toDto(Category category){
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }

    public Category toEntity(CategoryDto category){
        Category entity = new Category();
        entity.setId(category.getId());
        entity.setName(category.getName());
        entity.setDescription(category.getDescription());
        return entity;
    }

}
