package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.converter.Impl.EnderecoConverterImpl;
import com.fundatec.ti20.estacionamento.dto.request.EnderecoRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.EnderecoResponseDto;
import com.fundatec.ti20.estacionamento.model.Endereco;
import com.fundatec.ti20.estacionamento.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/enderecos")
public class EnderecoController {
    @Autowired
    private final EnderecoService service;
    @Autowired
    private final EnderecoConverterImpl converter;

    public EnderecoController(EnderecoService service, EnderecoConverterImpl converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<EnderecoResponseDto> findEmderecoById(@PathVariable("id") Integer id) {
        Endereco endereco = service.findById(id);
        return ResponseEntity.ok(converter.convert(endereco));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<EnderecoResponseDto>> findAll() {
        List<Endereco> endereco = service.findAll();
        List<EnderecoResponseDto> enderecoResponseDto = endereco.stream()
                .map(converter::convert)
                .toList();
        return ResponseEntity.ok(enderecoResponseDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EnderecoResponseDto> salvar(@Valid @RequestBody EnderecoRequestDto enderecoRequestDto) {
        Endereco enderecoDto = service.salvar(converter.convert(enderecoRequestDto));
        return ResponseEntity.ok(converter.convert(enderecoDto));
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EnderecoResponseDto> atualizar(@Valid @RequestBody EnderecoRequestDto enderecoRequestDto) {
        Endereco endereco = service.atualizar(converter.convert(enderecoRequestDto));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(converter.convert(endereco));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        service.delete(id);
    }

}
