package org.formation.coffeemachine.mapper;

import org.formation.coffeemachine.dto.CreateCoffeeDto;
import org.formation.coffeemachine.dto.CoffeeDto;
import org.formation.coffeemachine.dto.UpdateCoffeeDto;
import org.formation.coffeemachine.entity.Coffee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CoffeeMapper {

    CoffeeDto toDto(Coffee coffee);

    @Mapping(target = "id", ignore = true)
    Coffee toEntity(CreateCoffeeDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Coffee entity, UpdateCoffeeDto dto);
}
