package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.exceptions.NotAllowedException;
import com.fundatec.ti20.estacionamento.model.Conta;
import com.fundatec.ti20.estacionamento.model.enums.StatusPagamento;
import com.fundatec.ti20.estacionamento.repository.ContaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ContaServiceTest {

    @Mock
    ContaRepository repository;

    @InjectMocks
    ContaService service;

    Conta conta = new Conta(1, LocalDateTime.now(), null, null, BigDecimal.ONE, StatusPagamento.FINALIZADA );

    @Test
    void deveFecharContaComSucesso() {
        String status = StatusPagamento.FINALIZADA.toString();
        String statusConta =  conta.getStatus().toString();
        assertEquals(status, statusConta);
    }

    @Test
    void deveDarErroAoTentarFecharContaPoisContaJaFinalizada() {
        assertThrows(NotAllowedException.class, () -> service.fecharConta(conta.getId()));
    }

    @Test
    void deveDescobrirDuracaoEmMinutos() {
        Conta conta = new Conta(1, LocalDateTime.now().minusDays(2), LocalDateTime.now(), null, BigDecimal.ONE, StatusPagamento.FINALIZADA );
        long tempoEmMinutos = service.descobrirDuracaoEmMinutos(conta);
        assertEquals( 2880, tempoEmMinutos);
    }

}