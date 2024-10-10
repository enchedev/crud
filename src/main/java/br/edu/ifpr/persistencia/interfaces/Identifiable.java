package br.edu.ifpr.persistencia.interfaces;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Identifiable {

    UUID id = UUID.randomUUID();

}
