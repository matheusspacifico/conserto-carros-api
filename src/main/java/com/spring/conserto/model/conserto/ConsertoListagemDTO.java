package com.spring.conserto.model.conserto;

import com.spring.conserto.model.veiculo.Marca;
import java.time.LocalDate;

public record ConsertoListagemDTO(
        Long id,
        LocalDate dataEntradaOficina,
        LocalDate dataSaidaOficina,
        String nomeMecanico,
        Marca marcaVeiculo,
        String modeloVeiculo
) {
        public ConsertoListagemDTO(Conserto conserto) {
                this(
                        conserto.getId(),
                        conserto.getDataEntradaOficina(),
                        conserto.getDataSaidaOficina(),
                        conserto.getMecanicoResponsavel().getNome(),
                        conserto.getVeiculoResponsavel().getMarca(),
                        conserto.getVeiculoResponsavel().getModelo()
                );
        }
}
