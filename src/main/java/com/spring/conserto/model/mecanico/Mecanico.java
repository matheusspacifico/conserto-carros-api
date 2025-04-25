package com.spring.conserto.model.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {

    private String nome;
    private int anosExperiencia;

    public Mecanico(MecanicoDTO mecanicoDTO) {
        this.nome = mecanicoDTO.nome();
        this.anosExperiencia = mecanicoDTO.anosExperiencia();
    }
}
