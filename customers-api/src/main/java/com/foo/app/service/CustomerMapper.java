package com.foo.app.service;

import com.foo.app.db.CustomerEntity;
import com.foo.app.rest.CustomerDto;
import org.mapstruct.*;

import java.util.List;

/**
 * Map DTOs to JPA Entities and vice-versa
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto entityToDTO(CustomerEntity project);

    List<CustomerDto> entityToDTO(Iterable<CustomerEntity> project);

    @Mapping(target = "id", ignore = true)
    CustomerEntity dtoToEntity(CustomerDto source);

    /**
     * Copy all non-null values from PersonDto source to PersonEntity target ('id' excluded)
     * As of MapStruct 1.5.5 there is no way to copy only non-null source fields to target
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void dtoToEntity(CustomerDto source, @MappingTarget CustomerEntity target);

}

