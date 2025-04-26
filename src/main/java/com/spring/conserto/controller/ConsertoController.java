package com.spring.conserto.controller;

import com.spring.conserto.model.conserto.*;
import com.spring.conserto.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ConsertoRetornoDTO> cadastrarConserto(@RequestBody @Valid ConsertoDTO consertoDTO, UriComponentsBuilder uriBuilder) {
        Conserto conserto = new Conserto(consertoDTO);
        repository.save(conserto);

        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ConsertoRetornoDTO(conserto));
    }

    @GetMapping
    public ResponseEntity<Page<Conserto>> listarTodosOsConsertos(Pageable pageable) {
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("algunsdados")
    public ResponseEntity<List<ConsertoListagemDTO>> listarAlgunsDados() {
        return ResponseEntity.ok(repository.findAllByAtivoTrue().stream().map(ConsertoListagemDTO::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsertoRetornoDTO> listarConsertoPorId(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);

        if (consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new ConsertoRetornoDTO(conserto));
        }

        return ResponseEntity.<ConsertoRetornoDTO>notFound().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ConsertoRetornoDTO> atualizarConserto(@RequestBody @Valid ConsertoAtualizacaoDTO consertoAtualizacaoDTO) {
        Conserto conserto = repository.getReferenceById(consertoAtualizacaoDTO.id());
        conserto.atualizarInformacoes(consertoAtualizacaoDTO);

        return ResponseEntity.ok(new ConsertoRetornoDTO(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirConserto(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);
        conserto.cancelarConserto();

        return ResponseEntity.noContent().build();
    }
}
