package com.spring.conserto.model.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record VeiculoDTO(

        @NotNull
        Marca marca,

        @NotBlank
        String modelo,

        @NotBlank
        @Pattern(regexp = "^\\d{4}$")
        String ano,

        String cor
) {

}
