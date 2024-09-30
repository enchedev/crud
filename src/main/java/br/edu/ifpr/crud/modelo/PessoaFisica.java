package br.edu.ifpr.crud.modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class PessoaFisica extends Pessoa {

    private String cpf;

    public PessoaFisica(String cpf, String nome, LocalDate nascimento, Endereco endereco) {
        super(nome, nascimento, endereco);
        this.cpf = cpf;
    }

}
