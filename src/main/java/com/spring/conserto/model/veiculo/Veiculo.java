package com.spring.conserto.model.veiculo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Enumerated(EnumType.STRING)
    private Marca marca;

    private String modelo;
    private String ano;

    private String cor;

    public Veiculo(VeiculoDTO veiculoDTO) {
        this.marca = veiculoDTO.marca();
        this.modelo = veiculoDTO.modelo();
        this.ano = veiculoDTO.ano();
        this.cor = veiculoDTO.cor();
    }
}
