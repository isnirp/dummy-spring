package com.flimbis.repo;

import com.flimbis.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Integer> {
    Optional<Topping> findByIdPizzaId(int id, int pizzaId);
}
