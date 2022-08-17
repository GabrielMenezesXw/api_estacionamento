package com.fundatec.ti20.estacionamento.model.enums;

public enum TipoTarifa {

    ATE_MEIA_HORA, ATE_UMA_HORA, HORA_ADICIONAL, DIARIA;


    public static TipoTarifa obterTipoPorTempoEmMinutos(Long tempoEmMinutos) {
        if (tempoEmMinutos <= 30) {
            return ATE_MEIA_HORA;
        }
        if (tempoEmMinutos <= 60) {
            return ATE_UMA_HORA;
        }
        if (tempoEmMinutos >= 60) {
            return HORA_ADICIONAL;
        }
        return DIARIA;
    }

}
