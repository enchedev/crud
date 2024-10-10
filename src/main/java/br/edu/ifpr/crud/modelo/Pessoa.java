package br.edu.ifpr.crud.modelo;

import br.edu.ifpr.persistencia.interfaces.Identifiable;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
abstract class Pessoa extends Identifiable {

    protected String nome;
    protected LocalDate nascimento;
    protected Endereco endereco;

}
