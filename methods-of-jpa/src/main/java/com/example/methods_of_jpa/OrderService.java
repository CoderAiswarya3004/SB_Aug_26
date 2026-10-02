package com.example.methods_of_jpa;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class OrderService {

    private final OrdersRepository ordersRepository;
    private final ProductRepository productRepository;
    // private final OrderService orderService;

    @Transactional 
    public void placeOrder(int productId , int quantity)
    {
        //find the product by its id
        var product = productRepository.findById(productId).orElseThrow();
        
        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);

        if(quantity == 10){
            throw new RuntimeException("Some error Occured");
        }

        var order = Orders.builder()
                    .productId(productId)
                    .quantity(quantity)
                    .totalPrice(product.getProductPrice()*quantity)
                   .build();
            ordersRepository.save(order); 
    }
}
