package com.project.javaweb.repositories;

import com.project.javaweb.entities.Category;
import com.project.javaweb.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductRepository {
    private Map<Long, Product> map = new HashMap<>();

    /* salvar uma nova categoria */
    public void save(Product obj) {
        map.put(obj.getId(), obj);
    }

    public Product findById(Long id) {
        return map.get(id);
    }

    /* retornar uma lista correspondente a todos os valores: */
    public List<Product> findAll() {
        return new ArrayList<Product>(map.values());
    }

}
