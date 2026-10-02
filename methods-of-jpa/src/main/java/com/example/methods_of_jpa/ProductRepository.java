package com.example.methods_of_jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
// import java.util.List;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;


// import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer>{
    Optional<Product> findByProductName(String name);

    List<Product> findAllByProductPriceBetween(double startprice,double endprice); 

    List<Product> findAllByProductPriceGreaterThanEqual(double price,Sort sort);
    //Test remaining keyword
    Optional<Product> findByProductNameAndProductBrand(String name , String Brand);

    //JPQL -> Java Persistance Query Language
    // @Query("SELECT p from Product p where p.productName=?1 AND p.productBrand=?2") // positional parameter //Supports named and positional parameter . 
    // Optional<Product> getProduct(String name , String brand);

    // @Query("SELECT p from Product p where p.productName=:name AND p.productBrand=:brand") //Named parameter
    // Optional<Product> getProduct(String name , String brand);

    @Query(nativeQuery = true, 
          value = "SELECT * FROM product p WHERE product_name=? AND product_brand=?")
    Optional<Product> getProduct(String name , String brand);

    @Modifying 
    @Transactional //:- while using any DML Query or performing multiple DB Operations 
    //-> Disadvantage can be used inside service or repository
    @Query(nativeQuery = true,
            value = "UPDATE product SET product_price=?2 WHERE product_id=?1")
    int updatePrice(int id , double price);
}
