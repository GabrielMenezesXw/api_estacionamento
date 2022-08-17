package com.fundatec.ti20.estacionamento.repository;

import com.fundatec.ti20.estacionamento.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@Repository
@EnableJpaRepositories
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
