package com.fundatec.ti20.estacionamento.service.strategy.veiculo;

import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;

import java.util.Map;

public class TarifaMoto implements TarifaPorVeiculoStrategy {
	
	private static final Map<TipoTarifa, Double> TARIFAS = Map.of(
			TipoTarifa.ATE_MEIA_HORA, 7.0, 
			TipoTarifa.ATE_UMA_HORA, 10.0, 
			TipoTarifa.HORA_ADICIONAL, 3.0, 
			TipoTarifa.DIARIA, 20.0);

	@Override
	public boolean veiculoEhDoTipo(TipoVeiculo tipoVeiculo) {
		return tipoVeiculo == TipoVeiculo.MOTO;
	}

	@Override
	public double getValorTarifa(TipoTarifa tipoTarifa) {
		return TARIFAS.get(tipoTarifa);
	}

}
