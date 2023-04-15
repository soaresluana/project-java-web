package com.project.javaweb.resources;

import com.project.javaweb.entities.Category;
import com.project.javaweb.repositories.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResources {

    private final CategoryRepository categoryRepository;

    public CategoryResources(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = categoryRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category cat = categoryRepository.findById(id) ;
        return ResponseEntity.ok().body(cat);
    }

}
