package com.challenge.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AluguelDTO {
    private LocalDate dataAluguel;
    private String modeloCarro;
    private int kmCarro;
    private String nomeCliente;
    private String telefoneCliente;
    private LocalDate dataDevolucao;
    private BigDecimal valor;
    private String pago;

    public AluguelDTO(LocalDate dataAluguel, String modeloCarro, int kmCarro, String nomeCliente, String telefoneCliente, LocalDate dataDevolucao, BigDecimal valor, String pago) {
        this.dataAluguel = dataAluguel;
        this.modeloCarro = modeloCarro;
        this.kmCarro = kmCarro;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.dataDevolucao = dataDevolucao;
        this.valor = valor;
        this.pago = pago;
    }

    public AluguelDTO() {}

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDate dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public int getKmCarro() {
        return kmCarro;
    }

    public void setKmCarro(int kmCarro) {
        this.kmCarro = kmCarro;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }
}
