package com.fundatec.ti20.estacionamento.converter.Impl;

import com.fundatec.ti20.estacionamento.converter.ContaConverter;
import com.fundatec.ti20.estacionamento.dto.request.ContaRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.ContaResponseDto;
import com.fundatec.ti20.estacionamento.model.Conta;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.service.VeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ContaConverterImpl implements ContaConverter<Conta, ContaResponseDto, ContaRequestDto> {

    private final VeiculoService veiculoService;

    @Override
    public ContaResponseDto convert(Conta conta) {
        return ContaResponseDto.builder()
                .idConta(conta.getId())
                .entrada(conta.getEntrada())
                .saida(conta.getSaida())
                .placaVeiculo(conta.getVeiculo().getPlaca())
                .valorPagamento(conta.getValorPagamento())
                .build();
    }

    @Override
    public Conta convert(ContaRequestDto conta) {
        return Conta.builder()
                .veiculo(veiculoService.findById(conta.getIdVeiculo()))
                .entrada(conta.getEntrada())
                .status(conta.getStatusPagamento())
                .build();
    }
}

