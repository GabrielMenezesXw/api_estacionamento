package com.fundatec.ti20.estacionamento.repository;

import com.fundatec.ti20.estacionamento.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    Optional<Veiculo> findByPlaca(String placa);

    @Query("SELECT count(v) FROM Veiculo v WHERE v.placa = :placa")
    public Long countVeiculoByPlaca(@Param("placa") String placa);

}
