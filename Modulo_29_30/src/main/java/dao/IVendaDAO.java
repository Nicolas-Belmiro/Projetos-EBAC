package main.java.dao;


import main.java.dao.generic_jdbc.IGenericDAO;
import main.java.domain.Venda;
import main.java.exeptions.DAOException;
import main.java.exeptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

}
