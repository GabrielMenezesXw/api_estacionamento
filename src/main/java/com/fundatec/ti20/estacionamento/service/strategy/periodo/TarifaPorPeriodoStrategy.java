package com.fundatec.ti20.estacionamento.service.strategy.periodo;


import com.fundatec.ti20.estacionamento.instance.TarifaPorVeiculoInstance;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import com.fundatec.ti20.estacionamento.service.strategy.veiculo.TarifaPorVeiculoStrategy;

public interface TarifaPorPeriodoStrategy {
	
	boolean compreendePeriodoUtilizado(long periodoUtilizadoEmMinutos);

	double calcular(TipoVeiculo veiculo, long periodoUtilizadoEmMinutos);
	
	default TarifaPorVeiculoStrategy getTarifaVeiculoStrategy(TipoVeiculo veiculo) {
		return TarifaPorVeiculoInstance.INSTANCIAS.get()
			.filter(estrategia -> estrategia.veiculoEhDoTipo(veiculo))
			.findFirst()
			.orElseThrow(() 
					-> new IllegalStateException("Nenhuma estratégia implementada para o tipo de veículo"));
	}

}
