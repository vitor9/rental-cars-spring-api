package com.challenge.rental_cars_spring_api.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "carro")
@Getter
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "ano")
    private String ano;

    @Column(name = "qtd_passageiros")
    private Integer qtdPassageiros;

    @Column(name = "km")
    private Integer km;

    @Column(name = "fabricante")
    private String fabricante;

    @Column(name = "vlr_diaria")
    private BigDecimal vlrDiaria;

    public Carro() {}

    public Carro(Long id, String modelo, String ano, Integer qtdPassageiros, Integer km, String fabricante, BigDecimal vlrDiaria) {
        this.id = id;
        this.modelo = modelo;
        this.ano = ano;
        this.qtdPassageiros = qtdPassageiros;
        this.km = km;
        this.fabricante = fabricante;
        this.vlrDiaria = vlrDiaria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Integer getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(Integer qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public BigDecimal getVlrDiaria() {
        return vlrDiaria;
    }

    public void setVlrDiaria(BigDecimal vlrDiaria) {
        this.vlrDiaria = vlrDiaria;
    }
}
