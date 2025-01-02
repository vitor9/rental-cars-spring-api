package com.challenge.service;

import com.challenge.rental_cars_spring_api.core.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.challenge.rental_cars_spring_api.core.domain.Carro;
import com.challenge.rental_cars_spring_api.core.domain.Aluguel;
import com.challenge.repository.CarroRepository;
import com.challenge.repository.AluguelRepository;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private AluguelRepository aluguelRepository;

    public List<Carro> listarTodosCarros() {
        return carroRepository.findAll();
    }

    public void processarArquivoRTN() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("RentReport.rtn").getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() == 20) {
                    Aluguel aluguel = new Aluguel();
                    Cliente cliente = new Cliente();
                    Carro carro = new Carro();

                    carro.setCarroId(Integer.parseInt(line.substring(0, 2).trim())); // 1 a 2: ID do carro
                    cliente.setClienteId(Integer.parseInt(line.substring(2, 4).trim())); // 3 a 4: ID do cliente
                    aluguel.setDataAluguel(line.substring(4, 12).trim()); // 5 a 12: Data do aluguel
                    aluguel.setDataDevolucao(line.substring(12, 20).trim()); // 13 a 20: Data da devolução
                    // Delegate the persistence logic to the repository layer
                    salvarAluguel(aluguel);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void salvarAluguel(Aluguel aluguel) {
        aluguelRepository.save(aluguel);
    }
}
