package com.fundatec.ti20.estacionamento.controller;


import com.fundatec.ti20.estacionamento.converter.Impl.ContaConverterImpl;
import com.fundatec.ti20.estacionamento.dto.request.ContaRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.ContaResponseDto;
import com.fundatec.ti20.estacionamento.model.Conta;
import com.fundatec.ti20.estacionamento.service.CalcularContaService;
import com.fundatec.ti20.estacionamento.service.ContaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/contas")
public class
ContaController {

    @Autowired
    private final ContaService service;
    @Autowired
    private final CalcularContaService calcularContaService;
    @Autowired
    private final ContaConverterImpl converter;


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<ContaResponseDto> findContaById(@PathVariable Integer id) {
        Conta conta = service.findById(id);
        return ResponseEntity.ok(converter.convert(conta));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<ContaResponseDto>> findAll() {
        List<Conta> conta = service.findAll();
        List<ContaResponseDto> contaResponseDto = conta.stream()
                .map(converter::convert)
                .toList();
        return ResponseEntity.ok(contaResponseDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContaResponseDto> criarConta(@Valid @RequestBody ContaRequestDto contaRequestDto) {
        Conta contaDto = service.criarNovaConta(converter.convert(contaRequestDto), contaRequestDto.getIdVeiculo());
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convert(contaDto));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContaResponseDto> atualizar(@Valid @RequestBody ContaRequestDto contaRequestDto, @PathVariable Integer id) {
        Conta conta = service.salvar(converter.convert(contaRequestDto));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(converter.convert(conta));
    }

    @PutMapping("finalizar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContaResponseDto> finalizarConta(@Valid @PathVariable Integer id) {
        Conta conta = service.findById(id);
        LocalDateTime saida = LocalDateTime.now();
        calcularContaService.calcular(conta, saida);
        service.fecharConta(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(converter.convert(service.salvar(conta)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        service.delete(id);
    }

}
