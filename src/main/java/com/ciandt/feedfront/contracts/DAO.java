package com.ciandt.feedfront.contracts;

import java.util.List;

public interface DAO<E> {
    boolean tipoImplementaSerializable();

    List<E> listar();

    E buscar(String id);

    E salvar(E e);

    boolean apagar(String id);

}
