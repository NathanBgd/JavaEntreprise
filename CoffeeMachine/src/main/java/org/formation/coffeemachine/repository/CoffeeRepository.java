package org.formation.coffeemachine.repository;

import org.formation.coffeemachine.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

}
