package com.fundatec.ti20.estacionamento.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssinanteResponseDto {

        private Integer idAssinante;
        private String nome;
        private String cpf;
        private EnderecoResponseDto endereco;
        private BigDecimal creditoTotal;
    }

