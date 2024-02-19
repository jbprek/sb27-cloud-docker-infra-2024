package com.foo.app.db;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "subscription_id")
    private Long id;
    private Long customerId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    private Product productId;
    private LocalDate startDate;
    private Short durationMonths;

}