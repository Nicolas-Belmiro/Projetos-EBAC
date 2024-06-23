package teste.java.player.dao;

import main.Java.domain.Produto;
import main.Java.exception.TipoChaveNaoEncontradaException;

import java.util.Collection;



public class ProdutoDaoMock {

    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public Boolean excluir(Long valor) {
        return true;
    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {
    }

    @Override
    public Produto consultar(Long valor) {
        Produto produto = new Produto();
        produto.setCodigo(valor);
        return produto;
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return null;
    }
}
