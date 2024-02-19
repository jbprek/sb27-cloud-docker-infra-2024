package com.foo.app.rest;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.foo.app.db.Product}
 */
@Value
public class ProductDto implements Serializable {
    Long id;
    String name;
    Double price;
}