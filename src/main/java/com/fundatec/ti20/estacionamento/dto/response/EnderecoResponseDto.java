package com.fundatec.ti20.estacionamento.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnderecoResponseDto {

    private Integer idEndereco;
    private String logradouro;
    private String cep;

}
