package com.spring.conserto.model.autenticacao;

import jakarta.validation.constraints.NotBlank;

public record AutenticacaoDTO(

        @NotBlank
        String login,

        @NotBlank
        String senha

) {
}
