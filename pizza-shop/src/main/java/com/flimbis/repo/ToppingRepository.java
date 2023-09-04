package com.flimbis.repo;

import com.flimbis.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToppingRepository extends JpaRepository<Topping, Integer> {
}
