package com.fundatec.ti20.estacionamento.controller;

import com.fundatec.ti20.estacionamento.converter.Impl.VeiculoConverterImpl;
import com.fundatec.ti20.estacionamento.dto.request.VeiculoRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.VeiculoResponseDto;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.service.VeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/v1/veiculos")
public class VeiculoController {

    @Autowired
    private final VeiculoService service;
    @Autowired
    private final VeiculoConverterImpl converter;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<VeiculoResponseDto> findById(@PathVariable("id") Integer id) {
        Veiculo veiculo = service.findById(id);
        return ResponseEntity.ok(converter.convert(veiculo));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<VeiculoResponseDto>> findAll() {
        List<Veiculo> veiculo = service.findAll();
        List<VeiculoResponseDto> veiculoResponseDto = veiculo.stream()
                .map(converter::convert)
                .toList();
        return ResponseEntity.ok(veiculoResponseDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VeiculoResponseDto> salvar(@Valid @RequestBody VeiculoRequestDto veiculoRequestDto) {
        Veiculo veiculo = service.salvar(converter.convert(veiculoRequestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convert(veiculo));
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<VeiculoResponseDto> atualizar(@Valid @RequestBody VeiculoRequestDto veiculoRequestDto) {
        Veiculo veiculo = service.salvar(converter.convert(veiculoRequestDto));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(converter.convert(veiculo));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        service.delete(id);
    }

}
