package com.fundatec.ti20.estacionamento.repository;

import com.fundatec.ti20.estacionamento.model.Assinante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AssinanteRepository extends JpaRepository<Assinante, Integer> {

    @Query("SELECT count(a) FROM Assinante a WHERE a.cpf = :cpf")
    public Long countAssinanteByCpf(@Param("cpf") String cpf);
}
