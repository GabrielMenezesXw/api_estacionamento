package com.fundatec.ti20.estacionamento.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fundatec.ti20.estacionamento.model.enums.StatusPagamento;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@With
@Table(name = "tb_conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta_id")
    private Integer id;

    @Column(nullable = false, name = "entrada")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime entrada;

    @Column(name = "saida")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime saida;

    @NotBlank(message = "por favor informe o veículo")
    @OneToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @Column(name = "valor_pagamento")
    @Positive(message = "o valor precisa ser positivo")
    @Pattern(regexp = "^[1-9]\\d{0,2}(\\.\\d{3})*,\\d{2}$", message = "valor digitado no formato errado")
    private BigDecimal valorPagamento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "status")
    private StatusPagamento status;
}