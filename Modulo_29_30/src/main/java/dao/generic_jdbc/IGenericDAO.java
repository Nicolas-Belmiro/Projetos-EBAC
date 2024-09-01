package main.java.dao.generic_jdbc;


import main.java.dao.Persistente;
import main.java.exeptions.DAOException;
import main.java.exeptions.MaisDeUmRegistroException;
import main.java.exeptions.TableException;
import main.java.exeptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;


/**
 * Interface genérica para métodos de CRUD(Create, Read, Update and Delete)
 */
public interface IGenericDAO<T extends Persistente, E extends Serializable> {

    /**
     * Método para cadastrar novos registro no banco de dados
     *
     * @param entity a ser cadastrado
     * @return retorna verdadeiro para cadastrado e falso para não cadastrado
     */
    Boolean cadastrar(T entity) throws  TipoChaveNaoEncontradaException, DAOException;


    /**
     * Método para excluir um registro do banco de dados
     *
     * @param valor chave única do dado a ser excluído
     */
    void excluir(E valor) throws DAOException;


    /**
     * Método para alterar um registro no bando de dados.
     *
     * @param entity a ser atualizado
     */
    void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;


    /**
     * Método para consultar um registro no banco de dados
     *
     * @param valor chave única do dado a ser consultado
     * @return
     * @throws MaisDeUmRegistroException
     * @throws TableException
     */
    T consultar(E valor) throws  DAOException, MaisDeUmRegistroException, TableException;


    /**
     * Método que irá retornar todos os registros do banco de dados de uma determinado dado ou tabela
     *
     * @return Registros encontrados
     * @throws DAOException
     */
    Collection<T> buscarTodos() throws DAOException;


}