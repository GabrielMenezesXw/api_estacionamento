package com.fundatec.ti20.estacionamento.service.strategy.veiculo;


import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;

public interface TarifaPorVeiculoStrategy {

	boolean veiculoEhDoTipo(TipoVeiculo tipoVeiculo);

	double getValorTarifa(TipoTarifa tipoTarifa);

}
