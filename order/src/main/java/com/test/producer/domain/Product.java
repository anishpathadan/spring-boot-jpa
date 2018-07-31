package com.test.producer.domain;

import lombok.Data;
import lombok.Value;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table(name="PRODUCT_INFO")
public class Product {
    @Id
    @GenericGenerator(strategy = "uuid2",name = "uuid")
    @GeneratedValue(generator = "uuid")
    String id;

    @Column(name = "NAME",length = 30)
    String name;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    Set<LineItem> lineItems;
}
