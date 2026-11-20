package org.formation.coffeemachine.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.formation.coffeemachine.dto.CreateCoffeeDto;
import org.formation.coffeemachine.dto.CoffeeDto;
import org.formation.coffeemachine.dto.UpdateCoffeeDto;
import org.formation.coffeemachine.service.CoffeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;

    @PostMapping
    public CoffeeDto create(@RequestBody @Valid CreateCoffeeDto dto) {
        return coffeeService.create(dto);
    }

    @GetMapping
    List<CoffeeDto> coffees() {
        return coffeeService.allCoffees();
    }

    @GetMapping("{id}")
    ResponseEntity<CoffeeDto> coffee(@PathVariable Long id) {
        return coffeeService.oneCoffee(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("{id}")
    ResponseEntity<CoffeeDto> update(@PathVariable Long id, @RequestBody @Valid UpdateCoffeeDto dto) {
        return coffeeService.update(dto, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
