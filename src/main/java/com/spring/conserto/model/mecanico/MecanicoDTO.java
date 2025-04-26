package com.spring.conserto.model.mecanico;

import jakarta.validation.constraints.NotBlank;

public record MecanicoDTO(

        @NotBlank
        String nome,

        int anosExperiencia
) {
}
