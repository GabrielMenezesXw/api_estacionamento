package com.fundatec.ti20.estacionamento.service;

import com.fundatec.ti20.estacionamento.exceptions.ConflitoException;
import com.fundatec.ti20.estacionamento.exceptions.ObjectNotFoundException;
import com.fundatec.ti20.estacionamento.model.Conta;
import com.fundatec.ti20.estacionamento.model.Tarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import com.fundatec.ti20.estacionamento.repository.TarifaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@AllArgsConstructor
public class TarifaService {

    @Autowired
    private final TarifaRepository repository;


    public Tarifa find(TipoTarifa tipoTarifa, TipoVeiculo tipoVeiculo) {
        return repository.findByTipoTarifaAndTipoVeiculo(tipoTarifa,
                tipoVeiculo).orElseThrow(() -> new ObjectNotFoundException("Tarifa"));
    }

    public List<Tarifa> findAll() {
        if(repository.findAll().isEmpty()){
            throw new ObjectNotFoundException("nenhuma tarifa, o banco de dados está vazio");
        }
        return repository.findAll();
    }

    public Tarifa findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Tarifa"));
    }

    public Tarifa salvar(Tarifa tarifa) {
        if (repository.findAll().contains(tarifa)){
            throw new ConflitoException("tarifa");
        }
        return repository.save(tarifa);
    }

    public void delete(Integer id) {
        if (!repository.findAll().contains(id)){
            throw new ObjectNotFoundException("tarifa");
        }
        repository.deleteById(id);
    }


}