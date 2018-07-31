package com.test.producer.domain;

import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name="CUSTOMER")
public class Customer {
    @Id
    @GenericGenerator(strategy = "uuid2",name = "uuid")
    @GeneratedValue(generator = "uuid")
    String id;

    @Column(name="NAME",length = 30)
    String name;

    @Column(name="ADDRESS",length = 100)
    String address;

    @OneToMany(mappedBy = "customer", targetEntity=Order.class,
            fetch=FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<Order> orders;


}
