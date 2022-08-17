package com.fundatec.ti20.estacionamento.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContaResponseDto {

    private Integer idConta;
    private String placaVeiculo;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private BigDecimal valorPagamento;


}
