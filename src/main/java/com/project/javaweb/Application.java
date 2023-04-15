package com.project.javaweb;

import com.project.javaweb.entities.Category;
import com.project.javaweb.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final CategoryRepository categoryRepository;

	public Application(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category ct1 = new Category(1L, "ELETRONICS");
		Category ct2 = new Category(2L, "BOOKS");

		categoryRepository.save(ct1);
		categoryRepository.save(ct2);
	}

	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}
}
