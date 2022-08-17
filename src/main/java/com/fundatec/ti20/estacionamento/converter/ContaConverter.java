package com.fundatec.ti20.estacionamento.converter;

import com.fundatec.ti20.estacionamento.dto.request.ContaRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.ContaResponseDto;
import com.fundatec.ti20.estacionamento.model.Conta;
import org.springframework.stereotype.Component;

@Component
public interface ContaConverter<M extends Conta, R extends ContaResponseDto, Re extends ContaRequestDto> {

    R convert(M conta);

    M convert(Re conta);
}
