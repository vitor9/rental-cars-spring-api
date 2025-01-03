package com.challenge.controller;

import com.challenge.dto.AluguelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.challenge.service.AluguelService;
import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @GetMapping
    public List<AluguelDTO> listarAlugueis() {
        return aluguelService.listarAlugueis();
    }
}
