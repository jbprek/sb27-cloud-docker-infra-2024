package com.foo.app.rest;

import lombok.Value;

import java.time.LocalDate;

@Value
public class CustomerDto {

    Long id;
    String firstName;
    String lastName;
    LocalDate birthDate;
    String country;

}
