package com.spring.conserto.model.conserto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ConsertoAtualizacaoDTO(

        @NotNull
        Long id,

        LocalDate dataSaidaOficina,
        String nomeMecanico,
        int anosExperiencia
) {

}
