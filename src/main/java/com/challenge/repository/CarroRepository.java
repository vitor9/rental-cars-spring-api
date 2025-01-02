package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
    
import org.springframework.stereotype.Repository;
import com.challenge.rental_cars_spring_api.core.domain.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    
}
