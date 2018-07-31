package com.test.producer.repository;

import com.test.producer.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories
public interface OrderRepository extends CrudRepository<Order,String> {

}
