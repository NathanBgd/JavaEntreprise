package org.formation.coffeemachine.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.formation.coffeemachine.dto.CreateCoffeeDto;
import org.formation.coffeemachine.dto.CoffeeDto;
import org.formation.coffeemachine.dto.UpdateCoffeeDto;
import org.formation.coffeemachine.entity.Coffee;
import org.formation.coffeemachine.mapper.CoffeeMapper;
import org.formation.coffeemachine.repository.CoffeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository repository;
    private final CoffeeMapper mapper;

    @PostConstruct
    void initDb() {
        repository.saveAll(List.of(
                new Coffee("Expresso", 54),
                new Coffee("Latte", 52),
                new Coffee("Caffé au lait", 54)
        ));
    }

    @Override
    public List<CoffeeDto> allCoffees() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Optional<CoffeeDto> oneCoffee(@PathVariable Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public CoffeeDto create(CreateCoffeeDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Transactional
    @Override
    public Optional<CoffeeDto> update(UpdateCoffeeDto dto, Long id) {
        return repository.findById(id).map(existing -> {
            mapper.updateEntity(existing, dto);
            return mapper.toDto(existing);
        });
    }
}
