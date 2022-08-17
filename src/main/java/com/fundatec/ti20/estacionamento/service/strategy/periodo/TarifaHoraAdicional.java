package com.fundatec.ti20.estacionamento.service.strategy.periodo;


import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;

import static com.fundatec.ti20.estacionamento.util.Constants.SEIS_HORAS;
import static com.fundatec.ti20.estacionamento.util.Constants.UMA_HORA;

public class TarifaHoraAdicional implements TarifaPorPeriodoStrategy {

    @Override
    public boolean compreendePeriodoUtilizado(long periodoUtilizadoEmMinutos) {
        return periodoUtilizadoEmMinutos > UMA_HORA
                && periodoUtilizadoEmMinutos <= SEIS_HORAS;
    }

    @Override
    public double calcular(TipoVeiculo veiculo, long periodoUtilizadoEmMinutos) {
        long horasAdicionais = periodoUtilizadoEmMinutos % UMA_HORA > 0
                ? periodoUtilizadoEmMinutos / UMA_HORA
                : periodoUtilizadoEmMinutos / UMA_HORA - 1;
        double valorAteUmaHora = getTarifaVeiculoStrategy(veiculo)
                .getValorTarifa(TipoTarifa.ATE_UMA_HORA);
        double valorHoraAdicional = getTarifaVeiculoStrategy(veiculo)
                .getValorTarifa(TipoTarifa.HORA_ADICIONAL);

        return horasAdicionais * valorHoraAdicional + valorAteUmaHora;
    }

}
