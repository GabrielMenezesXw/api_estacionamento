package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.exceptions.ConflitoException;
import com.fundatec.ti20.estacionamento.exceptions.ObjectNotFoundException;
import com.fundatec.ti20.estacionamento.model.Assinante;
import com.fundatec.ti20.estacionamento.model.Conta;
import com.fundatec.ti20.estacionamento.model.Veiculo;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import com.fundatec.ti20.estacionamento.repository.VeiculoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VeiculoServiceTest {


    @Mock
    VeiculoRepository repository;

    @InjectMocks
    VeiculoService service;

    Assinante assinante = new Assinante();
    Conta conta = new Conta();
    Veiculo veiculo =new Veiculo(1, TipoVeiculo.CARRO,"aosieh1", assinante, conta);

    @Test
    void deveDarErroAoTentarAcharVeiculoPoisBancoVazio() {
        repository.deleteAll();
        assertThrows(ObjectNotFoundException.class, () -> service.findById(1));
    }

    @Test
    void deveDarErroAoTentarAcharPlacaPoisBancoVazio() {
        Assinante assinante = new Assinante();
        Conta conta = new Conta();
        repository.save(new Veiculo(1, TipoVeiculo.CARRO,"aosieh1", assinante, conta));
        repository.deleteAll();
        assertThrows(ObjectNotFoundException.class, () -> service.findByplaca("aosieh1"));
    }

    @Test
    void deveDarErroAoTentarAcharTodosPoisBancoVazio() {
        repository.deleteAll();
        assertThrows(ObjectNotFoundException.class, () -> service.findAll());
    }

    @Test
    void deveDarErroAoTentarSalvarVeiculoPoisEntraEmConflito() {
        service.salvar(veiculo);
        assertThrows(ConflitoException.class, () -> service.salvar(veiculo));
        service.findByplaca(veiculo.getPlaca());
    }

    @Test
    void DeveDarErroAoDeletarVeiculoPoisObjetoInexistente() {
        Assinante assinante = new Assinante();
        Conta conta = new Conta();
        repository.save(new Veiculo(1, TipoVeiculo.CARRO,"aosieh1", assinante, conta));
        repository.deleteById(1);
        assertThrows(ObjectNotFoundException.class, () -> service.delete(1));

    }
}