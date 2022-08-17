package com.fundatec.ti20.estacionamento.service.strategy.periodo;

import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;

import static com.fundatec.ti20.estacionamento.util.Constants.SEIS_HORAS;

public class TarifaDiaria implements TarifaPorPeriodoStrategy {

	@Override
	public boolean compreendePeriodoUtilizado(long periodoUtilizadoEmMinutos) {
		return periodoUtilizadoEmMinutos > SEIS_HORAS;
	}

	@Override
	public double calcular(TipoVeiculo veiculo, long periodoUtilizadoEmMinutos) {
		return getTarifaVeiculoStrategy(veiculo)
				.getValorTarifa(TipoTarifa.DIARIA);
	}

}
