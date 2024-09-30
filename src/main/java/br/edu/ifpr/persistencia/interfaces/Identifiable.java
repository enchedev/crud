package br.edu.ifpr.persistencia.interfaces;

import java.util.UUID;

public interface Identifiable {

    default UUID getId() {
        return UUID.randomUUID();
    }

}
