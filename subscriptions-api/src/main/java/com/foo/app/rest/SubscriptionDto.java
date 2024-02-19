package com.foo.app.rest;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.foo.app.db.Subscription}
 */
@Value
public class SubscriptionDto implements Serializable {
    Long id;
    Long customerId;
    String productName;
    LocalDate startDate;
    Short durationMonths;
}