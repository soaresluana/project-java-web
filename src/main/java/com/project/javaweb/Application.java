package com.project.javaweb;

import com.project.javaweb.entities.Category;
import com.project.javaweb.entities.Product;
import com.project.javaweb.repositories.CategoryRepository;
import com.project.javaweb.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final CategoryRepository categoryRepository;

	private final ProductRepository productRepository;

	public Application(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category ct1 = new Category(1L, "ELETRONICS");
		Category ct2 = new Category(2L, "BOOKS");

		Product p1 = new Product(1L, "TV", 2200.00, ct1);
		Product p2 = new Product(2L, "Domain Driven Design", 120.00, ct2);
		Product p3 = new Product(3L, "PS5", 2800.00, ct1);
		Product p4 = new Product(4L, "Docker Ebook", 99.90, ct2);

		ct1.getProducts().addAll(Arrays.asList(p1,p3));
		ct2.getProducts().addAll(Arrays.asList(p2,p4));

		categoryRepository.save(ct1);
		categoryRepository.save(ct2);

		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);

	}

	public CategoryRepository getCategoryRepository()  {
		return categoryRepository;
	}

	public ProductRepository getProductRepository() {
		return productRepository;
	}
}
