package br.edu.ifpr.crud.modelo;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisica extends Pessoa {

    protected String cpf;

}
