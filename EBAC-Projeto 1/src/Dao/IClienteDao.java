package Dao;


import DoMain.Cliente;

import java.util.Collection;

public interface IClienteDao {

    public Boolean cadastrar(Cliente cliente);

    public void excluir (Long cpf );

    public void alterar (Cliente cliente );

    public Cliente consultar ( Long cpf);

    public Collection <Cliente> buscarTodos();



}
