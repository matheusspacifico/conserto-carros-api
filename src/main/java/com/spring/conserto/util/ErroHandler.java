package com.spring.conserto.util;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErroHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> handle404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErroValidacao>> handle400(MethodArgumentNotValidException ex) {
        var erro = ex.getFieldErrors()
                .stream()
                .map(DadosErroValidacao::new)
                .toList();

        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<List<DadosErroValidacao>> handle400FormatoData(HttpMessageNotReadableException ex) {
        String campo = "desconhecido";
        String msg = "Formato inválido";

        if (ex.getCause() instanceof InvalidFormatException formatEx) {
            var path = formatEx.getPath();
            if (!path.isEmpty()) {
                campo = path.getFirst().getFieldName();
            }
            msg = "Valor inválido para data, formato esperado: dd-MM-yyyy";
        }

        var erro = new DadosErroValidacao(campo, msg);
        return ResponseEntity.badRequest().body(List.of(erro));
    }


    public record DadosErroValidacao(String campo, String msg) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
