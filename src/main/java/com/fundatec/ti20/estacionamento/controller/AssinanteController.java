package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.converter.Impl.AssinanteConverterImpl;
import com.fundatec.ti20.estacionamento.dto.request.AssinanteRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.AssinanteResponseDto;
import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.service.AssinanteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/assinantes")
public class AssinanteController {

    @Autowired
    private final AssinanteService service;
    @Autowired
    private final AssinanteConverterImpl converter;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<AssinanteResponseDto> findAssinanteById(@PathVariable Integer id) {
        Assinante assinante = service.findById(id);
        return ResponseEntity.ok(converter.convert(assinante));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<AssinanteResponseDto>> findAll() {
        List<Assinante> assinante = service.findAll();
        List<AssinanteResponseDto> assinanteResponseDto = assinante.stream()
                .map(converter::convert)
                .toList();
        return ResponseEntity.ok(assinanteResponseDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AssinanteResponseDto> salvar(@Valid @RequestBody AssinanteRequestDto assinanteRequestDto) {
        Assinante assinante = service.salvar(converter.convert(assinanteRequestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convert(assinante));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AssinanteResponseDto> atualizar(@Valid @RequestBody AssinanteRequestDto assinanteRequestDto) {
        Assinante assinante = service.atualizar(converter.convert(assinanteRequestDto));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(converter.convert(assinante));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        service.delete(id);
    }


}
