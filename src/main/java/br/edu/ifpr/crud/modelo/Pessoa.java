package br.edu.ifpr.crud.modelo;

import br.edu.ifpr.persistencia.interfaces.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Pessoa implements Identifiable {

    protected String nome;
    protected LocalDate nascimento;
    protected Endereco endereco;

}
