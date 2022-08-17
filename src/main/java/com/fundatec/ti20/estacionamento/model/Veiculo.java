package com.fundatec.ti20.estacionamento.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fundatec.ti20.estacionamento.model.enums.TipoVeiculo;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_veiculo")
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "pro favor informe o tipo do veiculo, pois isso influencia no preço")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_veiculo", nullable = false)
    private TipoVeiculo tipoVeiculo;

    @NotBlank(message = "placa necessária, n existe carro sem placa")
    @Size(min = 7, max = 7, message = "informe uma quantidade válida de digitos")
    @Pattern(regexp = "[A-Z]{2,3}[0-9]{4}|[A-Z]{3,4}[0-9]{3}|[A-Z0-9]{7}",
            message = "\nformmato inválido da placa, seguimos o padrão de todos os paises do mercosul")
    @Column(nullable = false, length = 7)
    private String placa;

    @JsonManagedReference
    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "assinante_id",nullable = true)
    private Assinante assinante;

    @NotBlank(message = "por favor informe a conta do veiculo")
    @OneToOne(mappedBy = "veiculo")
    @JoinColumn(name = "conta_id", referencedColumnName = "conta_id")
    private Conta conta;
}

