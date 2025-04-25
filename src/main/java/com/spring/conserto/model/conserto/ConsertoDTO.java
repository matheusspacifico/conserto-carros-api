package com.spring.conserto.model.conserto;

import com.spring.conserto.model.mecanico.MecanicoDTO;
import com.spring.conserto.model.veiculo.VeiculoDTO;

import java.time.LocalDate;

public record ConsertoDTO(
        LocalDate dataEntradaOficina,
        LocalDate dataSaidaOficina,
        MecanicoDTO mecanicoResponsavel,
        VeiculoDTO veiculoResponsavel
) {
}
