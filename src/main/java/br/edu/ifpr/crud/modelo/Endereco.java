package br.edu.ifpr.crud.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public final class Endereco {

    private String nomeRua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    Endereco(String nomeRua, Integer numero, String bairro, String cidade, String estado, String cep) {
        this.nomeRua = nomeRua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

}
