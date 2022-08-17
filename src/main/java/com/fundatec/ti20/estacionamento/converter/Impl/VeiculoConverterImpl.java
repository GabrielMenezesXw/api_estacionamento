package com.fundatec.ti20.estacionamento.converter.Impl;

import com.fundatec.ti20.estacionamento.converter.VeiculoConverter;
import com.fundatec.ti20.estacionamento.dto.request.AssinanteRequestDto;
import com.fundatec.ti20.estacionamento.dto.request.VeiculoRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.AssinanteResponseDto;
import com.fundatec.ti20.estacionamento.dto.response.VeiculoResponseDto;
import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.service.AssinanteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VeiculoConverterImpl implements VeiculoConverter<Veiculo, VeiculoResponseDto, VeiculoRequestDto> {


    @Autowired
    private final AssinanteService assinanteService;

    @Override
    public VeiculoResponseDto convert(Veiculo veiculo) {
        return VeiculoResponseDto.builder()
                .idVeiculo(veiculo.getId())
                .tipoVeiculo(veiculo.getTipoVeiculo())
                .placa(veiculo.getPlaca())
                .assinante(
                        veiculo.getAssinante() == null
                                ? null
                                : AssinanteResponseDto.builder()
                                .nome(veiculo.getAssinante().getNome())
                                .cpf(veiculo.getAssinante().getCpf())
                                .build())
                .build();
    }

    @Override
    public Veiculo convert(VeiculoRequestDto veiculo) {
        return Veiculo.builder()
                .tipoVeiculo(veiculo.getTipoVeiculo())
                .placa(veiculo.getPlaca())
                .assinante(assinanteService.findById(veiculo.getIdAssinante()))
                .build();
    }
}
