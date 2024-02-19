package com.foo.app.service;

import com.foo.app.db.Subscription;
import com.foo.app.rest.SubscriptionDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubscriptionMapper {
    Subscription toEntity(SubscriptionDto subscriptionDto);

    SubscriptionDto toDto(Subscription subscription);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Subscription partialUpdate(SubscriptionDto subscriptionDto, @MappingTarget Subscription subscription);
}