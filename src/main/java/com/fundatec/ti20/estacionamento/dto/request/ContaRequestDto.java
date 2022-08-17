package com.fundatec.ti20.estacionamento.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.model.enums.StatusPagamento;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContaRequestDto {

   private Integer idVeiculo;
   private LocalDateTime entrada;
   private StatusPagamento statusPagamento;

}
