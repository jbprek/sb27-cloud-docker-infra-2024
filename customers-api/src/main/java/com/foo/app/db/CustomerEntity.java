package com.foo.app.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMERS")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMERS_ID_GEN")
    @SequenceGenerator(name = "CUSTOMERS_ID_GEN", sequenceName = "CUSTOMERS_PK_SEQ", allocationSize = 1)
    @Column(name = "PERSON_ID", nullable = false)
    private Long id;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

}