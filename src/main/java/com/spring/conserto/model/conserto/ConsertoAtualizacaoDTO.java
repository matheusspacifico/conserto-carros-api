package com.spring.conserto.model.conserto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ConsertoAtualizacaoDTO(

        @NotNull
        Long id,

        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dataSaidaOficina,
        String nomeMecanico,
        int anosExperiencia
) {
        public ConsertoAtualizacaoDTO(Conserto conserto) {
                this(
                        conserto.getId(),
                        conserto.getDataSaidaOficina(),
                        conserto.getMecanicoResponsavel().getNome(),
                        conserto.getMecanicoResponsavel().getAnosExperiencia()
                );
        }
}
