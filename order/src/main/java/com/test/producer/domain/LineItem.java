package com.test.producer.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@Table(name="ORDER_LINE_ITEM")
public class LineItem {
    @Id
    @GenericGenerator(strategy = "uuid2",name = "uuid")
    @GeneratedValue(generator = "uuid")
    String id;

    @Column(name="QUANTITY")
    int quantity;

    @Column(name="PRICE")
    BigDecimal price;

    @ManyToOne
    @JoinColumn(name="ORDER_ID", nullable=false, updatable=false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Order order;

    @ManyToOne
    @JoinColumn(name="PRODUCT_ID", nullable=false, updatable=false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Product product;
}
