package com.foo.app.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTS_ID_GEN")
    @SequenceGenerator(name = "PRODUCTS_ID_GEN", sequenceName = "PRODUCTS_PK_SEQ", allocationSize = 1)
    @Column(name = "product_id")
    private Long id;
    private String name;
    private Double price;
}