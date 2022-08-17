package com.fundatec.ti20.estacionamento.converter;

import com.fundatec.ti20.estacionamento.dto.request.EnderecoRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.EnderecoResponseDto;
import com.fundatec.ti20.estacionamento.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public interface EnderecoConverter<M extends Endereco, R extends EnderecoResponseDto, Re extends EnderecoRequestDto> {

    R convert(M endereco);

    M convert(Re endereco);
}
