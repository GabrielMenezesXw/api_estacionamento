package com.fundatec.ti20.estacionamento.converter;

import com.fundatec.ti20.estacionamento.dto.request.TarifaRequestDto;
import com.fundatec.ti20.estacionamento.dto.response.TarifaResponseDto;
import com.fundatec.ti20.estacionamento.model.Tarifa;
import org.springframework.stereotype.Component;

@Component
public interface TarifaConverter<M extends Tarifa, R extends TarifaResponseDto, Re extends TarifaRequestDto> {

    R convert(M tarifa);

    M convert(Re tarifa);

}
