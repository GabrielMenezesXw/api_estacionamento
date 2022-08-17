package com.fundatec.ti20.estacionamento.dto.request;


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
public class TarifaRequestDto {

    private Integer id;
    private Integer contaId;


}

