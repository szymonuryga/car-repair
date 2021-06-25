package com.example.carrepair.model.category;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

     public List<Category> findAll(){
         return categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
     }

     public Optional<Category> findById(Long id){
         return categoryRepository.findById(id);
     }

     public void removeCategory(Long id){
         categoryRepository.deleteById(id);
     }

     public void saveCategory(Category category){
         categoryRepository.save(category);
     }
}
