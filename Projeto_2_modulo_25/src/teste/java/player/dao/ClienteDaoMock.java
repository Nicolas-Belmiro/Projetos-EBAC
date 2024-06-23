package teste.java.player.dao;

import main.Java.dao.IClienteDao;
import main.Java.domain.Cliente;
import main.Java.exception.TipoChaveNaoEncontradaException;

import java.util.Collection;


public class ClienteDaoMock implements IClienteDao {

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public Boolean excluir(Long valor) {
        return true;

    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return null;
    }
}
