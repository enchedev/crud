package br.edu.ifpr.crud.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public final class Endereco {

    private String nomeRua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

}
