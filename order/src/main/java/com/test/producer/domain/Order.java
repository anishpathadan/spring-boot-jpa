package com.test.producer.domain;

import lombok.Data;
import lombok.Value;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "ORDER_INFO")
public class Order {
    @Id
    @GenericGenerator(strategy = "uuid2",name = "uuid")
    @GeneratedValue(generator = "uuid")
    String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CUST_ID", nullable = false)
    Customer customer;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    Set<LineItem> lineItems = new HashSet<>();

    public void addLineItem(LineItem lineItem){
        lineItems.add(lineItem);
    }
}
