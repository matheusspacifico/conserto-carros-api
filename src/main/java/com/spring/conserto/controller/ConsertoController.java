package com.spring.conserto.controller;

import com.spring.conserto.model.conserto.Conserto;
import com.spring.conserto.model.conserto.ConsertoDTO;
import com.spring.conserto.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarConserto(@RequestBody ConsertoDTO consertoDTO) {
        repository.save(new Conserto(consertoDTO));
    }


}
