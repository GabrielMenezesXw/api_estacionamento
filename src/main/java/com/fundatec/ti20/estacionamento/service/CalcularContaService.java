package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.exceptions.NotAllowedException;
import com.fundatec.ti20.estacionamento.instance.TarifaPorPeriodoInstance;
import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.model.Conta;
import com.fundatec.ti20.estacionamento.model.enums.StatusPagamento;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import com.fundatec.ti20.estacionamento.service.strategy.periodo.TarifaPorPeriodoStrategy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@AllArgsConstructor
@Service
public class CalcularContaService {

    @Autowired
    private final ContaService contaService;
    @Autowired
    private final AssinanteService assinanteService;


    public Conta calcular(Conta conta, LocalDateTime saida) {
        conta.setSaida(saida);
        TipoVeiculo tipoVeiculo = conta.getVeiculo().getTipoVeiculo();
        long tempoEmMinutos = contaService.descobrirDuracaoEmMinutos(conta);
        BigDecimal calculo = BigDecimal.valueOf(getTarifaPeriodoStrategy(tempoEmMinutos).calcular(tipoVeiculo, tempoEmMinutos));
        conta.setValorPagamento(calculo);
        injetarDescontoAssinante(conta, calculo);
        return conta;
    }

    private Conta injetarDescontoAssinante(Conta conta, BigDecimal valorConta) {
        if(conta.getVeiculo().getAssinante() != null) {
            BigDecimal valorContaComDesconto =valorConta.multiply(BigDecimal.valueOf(0.90));
            conta.setValorPagamento(valorContaComDesconto);
            Assinante assinante = conta.getVeiculo().getAssinante();
            validacaoFundosNecessarios(conta, valorContaComDesconto);
            BigDecimal novoCredito = assinante.getCreditoTotal().subtract(valorContaComDesconto);
            assinante.setCreditoTotal(novoCredito);
            conta.setStatus(StatusPagamento.FINALIZADA);
            contaService.salvar(conta);
            assinanteService.salvar(assinante);
            return conta;
        }
        return conta;
    }

    private TarifaPorPeriodoStrategy getTarifaPeriodoStrategy(long periodoUtilizadoEmMinutos) {
        return TarifaPorPeriodoInstance.INSTANCIAS.get().filter(estrategia ->
                estrategia.compreendePeriodoUtilizado(periodoUtilizadoEmMinutos)).findFirst().orElseThrow(() ->
                new IllegalStateException("Nenhuma estratégia implementada para o período utilizado"));
    }

    private void validacaoFundosNecessarios(Conta conta, BigDecimal valorConta) {
        Assinante assinante = conta.getVeiculo().getAssinante();
        BigDecimal fundosDisponiveis = assinante.getCreditoTotal();
        if (valorConta.compareTo(fundosDisponiveis) > 0){
            throw new NotAllowedException("Você preicsa de mais fundos para fazer essa operação");
        }
    }
}
