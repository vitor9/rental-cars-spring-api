package com.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.challenge.service.CarroService;
import com.challenge.rental_cars_spring_api.core.domain.Carro;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<Carro> listarTodosCarros() {
        return carroService.listarTodosCarros();
    }
}
