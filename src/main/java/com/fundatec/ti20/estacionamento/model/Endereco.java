package com.fundatec.ti20.estacionamento.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_endereco")
public class Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "logradouro")
    @NotBlank(message = "informe o numero de sua residencia")
    private String logradouro;

    @NotBlank(message = "informe seu cep para sabermos sua rua, bairro e afins")
    @Size(min = 10, max = 10, message = "quantidade de digitos inválida")
    @Pattern(regexp = "(^\\d{5}-\\d{3}|^\\d{2}.\\d{3}-\\d{3}|\\d{8})")
    @Column(nullable = false, length = 10, name = "cep")
    private String cep;

}
