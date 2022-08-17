package com.fundatec.ti20.estacionamento.instance;


import com.fundatec.ti20.estacionamento.service.strategy.veiculo.TarifaCarro;
import com.fundatec.ti20.estacionamento.service.strategy.veiculo.TarifaMoto;
import com.fundatec.ti20.estacionamento.service.strategy.veiculo.TarifaPorVeiculoStrategy;

import java.util.function.Supplier;
import java.util.stream.Stream;

public final class TarifaPorVeiculoInstance {
	
	private TarifaPorVeiculoInstance() {
		throw new UnsupportedOperationException();
	}
	
	public static final Supplier<Stream<TarifaPorVeiculoStrategy>> INSTANCIAS =
			() -> Stream.of(
					new TarifaCarro(),
					new TarifaMoto());


}
