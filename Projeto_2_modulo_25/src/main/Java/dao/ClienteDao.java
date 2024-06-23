package main.Java.dao;

import main.Java.dao.generics.GenericDAO;
import main.Java.domain.Cliente;

public class ClienteDao extends GenericDAO<Cliente> implements IClienteDao {

    public ClienteDao() {
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
        // TODO Auto-generated method stub

    }

}