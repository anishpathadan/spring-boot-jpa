package com.test.producer.repository;

import com.test.producer.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,String> {
}
