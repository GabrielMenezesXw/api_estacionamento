package com.fundatec.ti20.estacionamento.model;

import com.fundatec.ti20.estacionamento.model.enums.TipoTarifa;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_tarifa")
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_tarifa", nullable = false)
    private TipoTarifa tipoTarifa;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_veiculo", nullable = false)
    private TipoVeiculo tipoVeiculo;

    @Positive(message = "o valor precisa ser positivo")
    @Pattern(regexp = "^[1-9]\\d{0,2}(\\.\\d{3})*,\\d{2}$", message = "valor digitado no formato errado")
    @Column(nullable = false)
    private BigDecimal valor;
}
