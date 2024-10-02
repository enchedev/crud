package br.edu.ifpr.persistencia.interfaces;

import java.util.UUID;

public interface Identifiable {

    UUID id = UUID.randomUUID();

    default UUID getId() {
        return id;
    }

}
