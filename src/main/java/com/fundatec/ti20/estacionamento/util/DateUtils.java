package com.fundatec.ti20.estacionamento.util;


import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;

public final class DateUtils {

	private DateUtils() {
		throw new UnsupportedOperationException();
	}

	public static long obterTempoEmMinutos(Date inicio, Date fim) {
		return ChronoUnit.MINUTES.between((Temporal) inicio, (Temporal) fim);
	}

}
