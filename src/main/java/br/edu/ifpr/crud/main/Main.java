package br.edu.ifpr.crud.main;

import br.edu.ifpr.crud.modelo.PessoaFisica;
import br.edu.ifpr.crud.modelo.PessoaFisicaFluent;
import br.edu.ifpr.crud.modelo.PessoaJuridica;
import br.edu.ifpr.crud.modelo.PessoaJuridicaFluent;
import br.edu.ifpr.crud.persistencia.PessoaFisicaPersistencia;
import br.edu.ifpr.crud.persistencia.PessoaJuridicaPersistencia;
import br.edu.ifpr.crud.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Main {

    final PessoaFisicaPersistencia pessoaFisicaPersistencia = new PessoaFisicaPersistencia();
    final PessoaJuridicaPersistencia pessoaJuridicaPersistencia = new PessoaJuridicaPersistencia();

    void inicializarPessoasFisicas() {
        for (var letter = 'A'; letter != 'Z'; letter += 1) {
            pessoaFisicaPersistencia.insert(
                PessoaFisicaFluent
                    .make()
                    .withCpf("CPF " + letter)
                    .withNome("NOME " + letter)
                    .withNascimento(2024, Month.JANUARY, 1)
                    .withEndereco("RUA " + letter, 69, "BAIRRO " + letter, "CIDADE " + letter, "ESTADO " + letter, "CEP " + letter)
            );
        }
    }

    void inicializarPessoasJuridicas() {
        for (var letter = 'A'; letter != 'Z'; letter += 1) {
            pessoaJuridicaPersistencia.insert(
                PessoaJuridicaFluent
                    .make()
                    .withCnpj("CNPJ " + letter)
                    .withNomeFantasia("NOME_FANTASIA " + letter)
                    .withNome("NOME " + letter)
                    .withNascimento(2024, Month.JANUARY, 1)
                    .withEndereco("RUA " + letter, 69, "BAIRRO " + letter, "CIDADE " + letter, "ESTADO " + letter, "CEP " + letter)
            );
        }
    }

    List<PessoaFisica> pesquisarPessoasMaioresDeIdade() {
        final var MAIORIDADE = 18;
        return pessoaFisicaPersistencia
            .select(ctx -> ctx
                .where(query -> query
                    .is(data -> LocalDate.now().getYear() - data.getYear() >= MAIORIDADE, PessoaFisica::getNascimento)
                )
            )
            .getAll()
        ;
    }

    List<PessoaFisica> pesquisarPessoasPorEstado(String estado) {
        return pessoaFisicaPersistencia
            .select(ctx -> ctx
                .where(query -> query
                    .is(endereco -> endereco.getEstado().equals(estado), PessoaFisica::getEndereco)
                )
            )
            .getAll()
        ;
    }

    List<PessoaJuridica> pesquisarEmpresasPorEstado(String estado) {
        return pessoaJuridicaPersistencia
            .select(ctx -> ctx
                .where(query -> query
                    .is(endereco -> endereco.getEstado().equals(estado), PessoaJuridica::getEndereco)
                )
            )
            .getAll()
        ;
    }

    public Main(String... args) {
        inicializarPessoasFisicas();
        inicializarPessoasJuridicas();

        System.out.printf("Pessoas físicas por estado (ESTADO A):%n");
        pesquisarPessoasPorEstado("ESTADO A").forEach(pessoa -> {
            try {
                System.out.println(Utils.prettifyJson(Utils.objectAsJson(pessoa)));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.printf("%nPessoas físicas maiores de idade:%n");
        pesquisarPessoasMaioresDeIdade().forEach(pessoa -> {
            try {
                System.out.println(Utils.prettifyJson(Utils.objectAsJson(pessoa)));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.printf("%nPessoas jurídicas por estado (ESTADO G):%n");
        pesquisarEmpresasPorEstado("ESTADO G").forEach(pessoa -> {
            try {
                System.out.println(Utils.prettifyJson(Utils.objectAsJson(pessoa)));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void main(String[] args) {
        new Main(args);
    }

}
