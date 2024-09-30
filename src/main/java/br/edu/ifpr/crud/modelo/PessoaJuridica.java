package br.edu.ifpr.crud.modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public class PessoaJuridica extends Pessoa {

    private String cnpj;
    private String nomeFantasia;

    public PessoaJuridica(String cnpj, String nomeFantasia, String nome, LocalDate nascimento, Endereco endereco) {
        super(nome, nascimento, endereco);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

}
