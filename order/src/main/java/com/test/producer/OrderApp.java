package com.test.producer;

import com.test.producer.domain.Customer;
import com.test.producer.domain.LineItem;
import com.test.producer.domain.Order;
import com.test.producer.domain.Product;
import com.test.producer.repository.CustomerRepository;
import com.test.producer.repository.OrderRepository;
import com.test.producer.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@Slf4j
public class OrderApp {

    public static void main(String args[]){
        SpringApplication.run(OrderApp.class, args);
    }

    @Bean
    public CommandLineRunner demo(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        return (args) -> {
            Customer customer = new Customer();
            customer.setName("cust1");
            customer.setAddress("ccc");

            Customer customer1 = customerRepository.save(customer);
            log.info("customer:"+customer1);

            Product product = new Product();
            product.setName("iPhone");

            Product product1 = productRepository.save(product);
            log.info("product:"+product1);

            Order order = new Order();
            order.setCustomer(customer1);

            LineItem lineItem = new LineItem();
            lineItem.setOrder(order);
            lineItem.setPrice(new BigDecimal("10.2"));
            lineItem.setQuantity(10);
            lineItem.setProduct(product1);

            LineItem lineItem2 = new LineItem();
            lineItem2.setOrder(order);
            lineItem2.setPrice(new BigDecimal("99.99"));
            lineItem2.setQuantity(3);
            lineItem2.setProduct(product1);

            order.addLineItem(lineItem);
            order.addLineItem(lineItem2);

            log.info("Oder is:"+ orderRepository.save(order));
            log.info("Product is:"+productRepository.findById(product1.getId()));
        };
    }
}
