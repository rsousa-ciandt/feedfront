package com.ciandt.feedfront.contracts;

import com.ciandt.feedfront.excecoes.BusinessException;

import java.util.List;

public interface Service<E> {
    List<E> listar();

    E buscar(String id) throws BusinessException;

    E salvar(E e) throws BusinessException, IllegalArgumentException;

    E atualizar(E e) throws BusinessException, IllegalArgumentException;

    void apagar(String id) throws BusinessException;

    void setDAO(DAO<E> dao);
}
