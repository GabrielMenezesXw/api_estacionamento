package com.fundatec.ti20.estacionamento.converter.Impl;

import com.fundatec.ti20.estacionamento.converter.TarifaConverter;
import com.fundatec.ti20.estacionamento.dto.request.TarifaRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.TarifaResponseDto;
import com.fundatec.ti20.estacionamento.model.Tarifa;
import com.fundatec.ti20.estacionamento.service.ContaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TarifaConverterImpl implements TarifaConverter<Tarifa, TarifaResponseDto, TarifaRequestDto> {

    @Autowired
    private final ContaService contaService;

    @Override
    public TarifaResponseDto convert(Tarifa tarifa) {
        return TarifaResponseDto.builder()
                .id(tarifa.getId())
                .tipoVeiculo(tarifa.getTipoVeiculo())
                .tipoTarifa(tarifa.getTipoTarifa())
                .valor(tarifa.getValor())
                .build();
    }

    @Override
    public Tarifa convert(TarifaRequestDto tarifa) {
        return Tarifa.builder()
                .build();
    }
}
