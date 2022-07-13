package com.ciandt.feedfront.contracts;

import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;

import java.util.List;

public interface Service<E> {
    List<E> listar() throws ArquivoException;

    E buscar(String id) throws ArquivoException, BusinessException;

    E salvar(E e) throws ArquivoException, BusinessException;

    E atualizar(E e) throws ArquivoException, BusinessException;

    void apagar(String id) throws ArquivoException, BusinessException;

}
