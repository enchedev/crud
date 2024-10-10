package br.edu.ifpr.crud.modelo;

import java.time.LocalDate;
import java.time.Month;

public class PessoaJuridicaFluent extends PessoaJuridica {

    public static PessoaJuridicaFluent make() {
        return new PessoaJuridicaFluent();
    }

    public PessoaJuridicaFluent withCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public PessoaJuridicaFluent withNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
        return this;
    }

    public PessoaJuridicaFluent withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaJuridicaFluent withNascimento(Integer ano, Month mes, Integer diaDaSemana) {
        this.nascimento = LocalDate.of(ano, mes, diaDaSemana);
        return this;
    }

    public PessoaJuridicaFluent withEndereco(String nomeRua, Integer numero, String bairro, String cidade, String estado, String cep) {
        this.endereco = new Endereco(nomeRua, numero, bairro, cidade, estado, cep);
        return this;
    }

}
