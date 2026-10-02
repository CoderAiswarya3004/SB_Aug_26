package com.example.methods_of_jpa;

import java.beans.BeanProperty;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor 
public class MethodsOfJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MethodsOfJpaApplication.class, args);
	}

	private final ProductRepository productRepository;
	private final OrderService orderService;

	@Bean 
	public CommandLineRunner commandLineRunner(){
		return args -> {
			Product product = Product.builder()
			.productName("IPhone 17 Pro Max")
			.productBrand("Apple")
			.productPrice(180000.99)
			.build();

			//SAVE
			// Product savedRepository = productRepository.save(product);
			// System.out.println("saved product is :" + savedRepository);

			//SAVEALL
			// productRepository.saveAll(getProducts());

			//COUNT
			// long totalProducts = productRepository.count();
			// System.out.println("total number of products is:-"+totalProducts);

			//Exists & Exists By ID
			// Product iphone17 = productRepository.findById(1).orElseThrow();
			// boolean isIphoneExists = productRepository.existsById(1);
			// System.out.println("Is Iphone 17 exists:-"+ isIphoneExists);

			// Product existingProduct = productRepository.findById(1).orElseThrow();
			// boolean isIphoneExists2 = productRepository.exists(Example.of(existingProduct));
			// System.out.println("is Iphone 17 exists 2 :-" + isIphoneExists2);	

			// productRepository.deleteById(10);
			
			// List<Product> products = productRepository.findAll();
			// productRepository.deleteAll(products);

			//  List<Product> products = productRepository.findAll(Sort.by(Direction.DESC,"productName"));
			// products.forEach(System.out::println);

			//  List<Product> products = productRepository.findAll(Sort.by("productPrice"));
			// products.forEach(System.out::println);

			// Product iphone17 = productRepository.findById(11).orElseThrow();
			// iphone17.setProductBrand("Samsung");
			// productRepository.save(iphone17);	
			
			// Page<Product> products = productRepository.findAll(PageRequest.of(0,5,Direction.DESC)); -> Wrong
			// Page<Product> products = productRepository.findAll(PageRequest.of(0,5,
			// 														Direction.DESC,"productId"));

			// System.out.println("Page information is " + products);
			// //PageNumber -> 0 based Indexing
			// // pagesize -> number of data inside the page
			// products.forEach(System.out::println);

			//-------------To find by name 
			//================= Custom Query Methods , JPQL , Plain SQL / RAW SQL

			// Optional<Product> optGalaxy = productRepository.findByProductName("Corsair");

			// Product optGalaxy = productRepository.findByProductName("Mechanical Keyboard").orElseThrow();
			// System.out.println(optGalaxy);

			// productRepository.findAllByProductPriceBetween(10000, 50000)
			// .forEach(System.out::println);
			// System.out.println(findAll);

			// productRepository.findAllByProductPriceGreaterThanEqual(50000).forEach(System.out::println);
			// productRepository
			// 	.findAllByProductPriceGreaterThanEqual(1000,Sort.by(Direction.ASC,"productPrice"))
			// 	.forEach(System.out::println);

			// productRepository
			// .findByProductNameAndProductBrand("Mechanical Keyboard", "Corsair")
			// .ifPresent(p->System.out.println(p));

			// productRepository
			// .getProduct("Mechanical Keyboard", "Corsair")
			// .ifPresent(p->System.out.println(p));

			// int affectedPrice = productRepository.updatePrice(2, 12000);
			// System.out.println("No of Affected rows"+affectedPrice);

			orderService.placeOrder(1, 9);
		};
	}

	private List<Product> getProducts(){
		return IntStream.range(1, 10).mapToObj(i -> Product.builder()
		.productName("product -" + i)
		.productBrand("brand-"+i)
		.productPrice(1000*i)
		.build())
		.toList();
	}
}
