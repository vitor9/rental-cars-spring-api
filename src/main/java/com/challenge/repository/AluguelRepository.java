package com.challenge.repository;

import com.challenge.rental_cars_spring_api.core.domain.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
