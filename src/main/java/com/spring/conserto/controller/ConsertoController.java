package com.spring.conserto.controller;

import com.spring.conserto.model.conserto.Conserto;
import com.spring.conserto.model.conserto.ConsertoDTO;
import com.spring.conserto.model.conserto.ConsertoListagemDTO;
import com.spring.conserto.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarConserto(@RequestBody @Valid ConsertoDTO consertoDTO) {
        repository.save(new Conserto(consertoDTO));
    }

    @GetMapping
    public Page<Conserto> listarTodosOsConsertos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("algunsdados")
    public List<ConsertoListagemDTO> listarAlgunsDados() {
        return repository.findAll().stream().map(ConsertoListagemDTO::new).toList();
    }
}
