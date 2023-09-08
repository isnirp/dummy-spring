package com.flimbis.repo;

import com.flimbis.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Integer> {
    @Query(value = "Select * From topping t Where t.id = ?1 and t.pizza_id = ?2 ", nativeQuery = true)
    Optional<Topping> findByIdAndPizzaId(int id, int pizzaId);

    @Query(value = "Select * From topping t Where t.pizza_id = :pizzaId", nativeQuery = true)
    List<Topping> findAllToppingsByPizzaId(@Param("pizzaId") int pizzaId);
}
