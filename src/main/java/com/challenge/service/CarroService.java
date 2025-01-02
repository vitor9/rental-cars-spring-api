package com.challenge.service;

import com.challenge.rental_cars_spring_api.core.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.challenge.rental_cars_spring_api.core.domain.Carro;
import com.challenge.rental_cars_spring_api.core.domain.Aluguel;
import com.challenge.repository.CarroRepository;
import com.challenge.repository.AluguelRepository;
import com.challenge.repository.ClienteRepository;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private AluguelRepository aluguelRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Carro> listarTodosCarros() {
        return carroRepository.findAll();
    }

    public void processarArquivoRTN() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("RentReport.rtn").getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() == 20) {
                    Aluguel aluguel = getAluguel(line, formatter);
                    salvarAluguel(aluguel);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Aluguel getAluguel(String line, DateTimeFormatter formatter) {
        Aluguel aluguel = new Aluguel();
        Long carroId = Long.parseLong(line.substring(0, 2).trim()); // 1 a 2: ID do carro
        Long clienteId = Long.parseLong(line.substring(2, 4).trim()); // 3 a 4: ID do cliente

        Carro carro = carroRepository.findById(carroId).orElseThrow(() -> new RuntimeException("Carro não encontrado"));
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        aluguel.setCarro(carro);
        aluguel.setCliente(cliente);
        aluguel.setDataAluguel(LocalDate.parse(line.substring(4, 12).trim(), formatter)); // 5 a 12: Data do aluguel
        aluguel.setDataDevolucao(LocalDate.parse(line.substring(12, 20).trim(), formatter)); // 13 a 20: Data da devolução
        return aluguel;
    }

    private void salvarAluguel(Aluguel aluguel) {
        aluguelRepository.save(aluguel);
    }
}
