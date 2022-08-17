package com.fundatec.ti20.estacionamento.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VeiculoRequestDto {

    private TipoVeiculo tipoVeiculo;
    private String placa;
    private Integer idAssinante;

}
