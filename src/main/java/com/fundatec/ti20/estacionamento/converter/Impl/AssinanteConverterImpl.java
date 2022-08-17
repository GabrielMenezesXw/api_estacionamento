package com.fundatec.ti20.estacionamento.converter.Impl;

import com.fundatec.ti20.estacionamento.converter.AssinanteConverter;
import com.fundatec.ti20.estacionamento.dto.request.AssinanteRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.AssinanteResponseDto;
import com.fundatec.ti20.estacionamento.dto.response.EnderecoResponseDto;
import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.model.Endereco;
import com.fundatec.ti20.estacionamento.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AssinanteConverterImpl implements AssinanteConverter<Assinante, AssinanteResponseDto, AssinanteRequestDto> {

private final EnderecoService enderecoService;

    @Override
    public AssinanteResponseDto convert(Assinante assinante) {
        return AssinanteResponseDto.builder()
                .idAssinante(assinante.getId())
                .cpf(assinante.getCpf())
                .nome(assinante.getNome())
                .endereco(assinante.getEndereco() == null
                ? null
                        : EnderecoResponseDto.builder()
                        .logradouro(assinante.getEndereco().getLogradouro())
                        .cep(assinante.getEndereco().getCep())
                                .build()
                        )
                .creditoTotal(assinante.getCreditoTotal())
                .build();
    }

    @Override
    public Assinante convert(AssinanteRequestDto assinante) {
        return Assinante.builder().nome(assinante.getNome())
                .cpf(assinante.getCpf())
                .nome(assinante.getNome())
                .endereco(enderecoService.findById(assinante.getIdEndereco()))
                .creditoTotal(assinante.getCreditoTotal())
                .build();
    }
}
