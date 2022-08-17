package com.fundatec.ti20.estacionamento.converter;

import com.fundatec.ti20.estacionamento.dto.request.AssinanteRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.AssinanteResponseDto;
import com.fundatec.ti20.estacionamento.model.Assinante;
import org.springframework.stereotype.Component;

@Component
public interface AssinanteConverter<M extends Assinante, R extends AssinanteResponseDto, Re extends AssinanteRequestDto> {

    R convert(M assinante);

    M convert(Re assinante);
}
