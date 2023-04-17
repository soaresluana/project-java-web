package com.project.javaweb.repositories;

import com.project.javaweb.entities.Category;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CategoryRepository {

    private Map<Long, Category> map = new HashMap<>();

    /* salvar uma nova categoria */
    public void save(Category obj) {
        map.put(obj.getId(), obj);
    }

    public Category findById(Long id) {
        return map.get(id);
    }

    /* retornar uma lista correspondente a todos os valores: */
    public List<Category> findAll() {
        return new ArrayList<Category>(map.values());
    }


}
