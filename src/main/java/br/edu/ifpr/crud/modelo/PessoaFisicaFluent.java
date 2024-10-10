package br.edu.ifpr.crud.modelo;

import java.time.LocalDate;
import java.time.Month;

public class PessoaFisicaFluent extends PessoaFisica {

    public static PessoaFisicaFluent make() {
        return new PessoaFisicaFluent();
    }

    public PessoaFisicaFluent withCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public PessoaFisicaFluent withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaFisicaFluent withNascimento(Integer ano, Month mes, Integer diaDaSemana) {
        this.nascimento = LocalDate.of(ano, mes, diaDaSemana);
        return this;
    }

    public PessoaFisicaFluent withEndereco(String nomeRua, Integer numero, String bairro, String cidade, String estado, String cep) {
        this.endereco = new Endereco(nomeRua, numero, bairro, cidade, estado, cep);
        return this;
    }

}
