package com.fundatec.ti20.estacionamento.instance;

import com.fundatec.ti20.estacionamento.service.strategy.periodo.*;

import java.util.function.Supplier;
import java.util.stream.Stream;

public final class TarifaPorPeriodoInstance {
	
	private TarifaPorPeriodoInstance() {
		throw new UnsupportedOperationException();
	}
	
	public static final Supplier<Stream<TarifaPorPeriodoStrategy>> INSTANCIAS =
		() -> Stream.of(
				new TarifaAteMeiaHora(),
				new TarifaAteUmaHora(), 
				new TarifaHoraAdicional(), 
				new TarifaDiaria());
}
