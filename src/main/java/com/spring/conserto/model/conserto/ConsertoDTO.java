package com.spring.conserto.model.conserto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.conserto.model.mecanico.MecanicoDTO;
import com.spring.conserto.model.veiculo.VeiculoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ConsertoDTO(

        @NotNull
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dataEntradaOficina,

        @NotNull
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dataSaidaOficina,

        @NotNull
        @Valid
        MecanicoDTO mecanicoResponsavel,

        @NotNull
        @Valid
        VeiculoDTO veiculoResponsavel
) {
}
