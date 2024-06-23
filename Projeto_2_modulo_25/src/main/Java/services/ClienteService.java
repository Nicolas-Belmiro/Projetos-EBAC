package main.Java.services;

import main.Java.dao.IClienteDao;
import main.Java.domain.Cliente;
import main.Java.exception.TipoChaveNaoEncontradaException;

public class ClienteService implements IClienteService {

    private IClienteDao clienteDao;

    public ClienteService(IClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return clienteDao.cadastrar(cliente);
    }

    @Override
    public Cliente buscarPorCpf(Long cpf) {
        return clienteDao.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        clienteDao.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDao.alterar(cliente);

    }

}
