package com.fundatec.ti20.estacionamento.converter;

import com.fundatec.ti20.estacionamento.dto.request.VeiculoRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.VeiculoResponseDto;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import org.springframework.stereotype.Component;

@Component
public interface VeiculoConverter<M extends Veiculo, R extends VeiculoResponseDto, Re extends VeiculoRequestDto> {
    R convert(M veiculo);

    M convert(Re veiculo);
}
