package com.spring.conserto.model.conserto;

import com.spring.conserto.model.mecanico.MecanicoDTO;
import com.spring.conserto.model.veiculo.VeiculoDTO;

import java.time.LocalDate;

public record ConsertoRetornoDTO(
        LocalDate dataEntradaOficina,
        LocalDate dataSaidaOficina,
        
        MecanicoDTO mecanicoResponsavel,
        VeiculoDTO veiculoResponsavel
) {
    public ConsertoRetornoDTO(Conserto conserto) {
        this(
            conserto.getDataEntradaOficina(),
            conserto.getDataSaidaOficina(),
            new MecanicoDTO(conserto.getMecanicoResponsavel().getNome(), conserto.getMecanicoResponsavel().getAnosExperiencia()),
            new VeiculoDTO(conserto.getVeiculoResponsavel().getMarca(), conserto.getVeiculoResponsavel().getModelo(), conserto.getVeiculoResponsavel().getAno(), conserto.getVeiculoResponsavel().getCor())
        );
    }
    
}
