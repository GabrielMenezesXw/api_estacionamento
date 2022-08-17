package com.fundatec.ti20.estacionamento.repository;

import com.fundatec.ti20.estacionamento.model.Tarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Integer> {

    Optional<Tarifa> findByTipoTarifaAndTipoVeiculo(TipoTarifa tipoTarifa, TipoVeiculo tipoVeiculo);

}
