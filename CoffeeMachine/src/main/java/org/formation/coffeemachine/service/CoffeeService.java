package org.formation.coffeemachine.service;

import org.formation.coffeemachine.dto.CreateCoffeeDto;
import org.formation.coffeemachine.dto.CoffeeDto;

import java.util.List;
import java.util.Optional;

public interface CoffeeService {

    List<CoffeeDto> allCoffees();

    Optional<CoffeeDto> oneCoffee(Long id);

    CoffeeDto create(CreateCoffeeDto dto);
}
