package com.project.javaweb.resources;
import java.util.List;

import com.project.javaweb.entities.Product;
import com.project.javaweb.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {

    private final ProductRepository productRepository;

    public ProductResources(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product ct = productRepository.findById(id);
        return ResponseEntity.ok().body(ct);
    }

}
