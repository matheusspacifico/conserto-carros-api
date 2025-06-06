package com.spring.conserto.controller;

import com.spring.conserto.model.autenticacao.AutenticacaoDTO;
import com.spring.conserto.model.autenticacao.Usuario;
import com.spring.conserto.util.security.ConsertoCarrosTokenDTO;
import com.spring.conserto.util.security.ConsertoCarrosTokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    private final AuthenticationManager manager;
    private final ConsertoCarrosTokenService tokenService;

    public AutenticacaoController(AuthenticationManager manager, ConsertoCarrosTokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<ConsertoCarrosTokenDTO> efetuarLogin(@RequestBody @Valid AutenticacaoDTO dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new ConsertoCarrosTokenDTO(tokenJWT));
    }
}
