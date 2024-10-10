package br.edu.ifpr.crud.modelo;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PessoaJuridica extends Pessoa {

    protected String cnpj;
    protected String nomeFantasia;

}
