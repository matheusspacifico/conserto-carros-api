package com.spring.conserto.model.conserto;

import com.spring.conserto.model.mecanico.Mecanico;
import com.spring.conserto.model.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataEntradaOficina;
    private LocalDate dataSaidaOficina;

    @Embedded
    private Mecanico mecanicoResponsavel;

    @Embedded
    private Veiculo veiculoResponsavel;

    public Conserto(ConsertoDTO consertoDTO) {
        this.dataEntradaOficina = consertoDTO.dataEntradaOficina();
        this.dataSaidaOficina = consertoDTO.dataSaidaOficina();
        this.mecanicoResponsavel = new Mecanico(consertoDTO.mecanicoResponsavel());
        this.veiculoResponsavel = new Veiculo(consertoDTO.veiculoResponsavel());
    }

    public void atualizarInformacoes(ConsertoAtualizacaoDTO consertoAtualizacaoDTO) {
        if (consertoAtualizacaoDTO.dataSaidaOficina() != null) {
            this.dataSaidaOficina = consertoAtualizacaoDTO.dataSaidaOficina();
        }
        if (consertoAtualizacaoDTO.nomeMecanico() != null && consertoAtualizacaoDTO.anosExperiencia() > 0) {
            this.mecanicoResponsavel = new Mecanico(consertoAtualizacaoDTO.nomeMecanico(), consertoAtualizacaoDTO.anosExperiencia());
        }
    }
}
