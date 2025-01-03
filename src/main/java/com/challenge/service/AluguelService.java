package com.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.challenge.rental_cars_spring_api.core.domain.Aluguel;
import com.challenge.repository.AluguelRepository;
import com.challenge.dto.AluguelDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    public List<AluguelDTO> listarAlugueis() {
        return aluguelRepository.findAll().stream().map(aluguel -> new AluguelDTO(
            aluguel.getDataAluguel(),
            aluguel.getCarro().getModelo(),
            aluguel.getCarro().getKm(),
            aluguel.getCliente().getNome(),
            String.format("+%s(%s)%s-%s", 
                aluguel.getCliente().getTelefone().substring(0, 2),
                aluguel.getCliente().getTelefone().substring(2, 4),
                aluguel.getCliente().getTelefone().substring(4, 9),
                aluguel.getCliente().getTelefone().substring(9)),
            aluguel.getDataDevolucao(),
            aluguel.getValor(),
            aluguel.isPago() ? "SIM" : "NAO"
        )).collect(Collectors.toList());
    }
}
