package main.Java.services;

import main.Java.dao.IProdutoDao;
import main.Java.domain.Produto;
import main.Java.exception.TipoChaveNaoEncontradaException;

public class ProdutoService implements IProdutoService{

    private IProdutoDao produtoDao;

    public ProdutoService(IProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }

    @Override
    public Boolean salvar(Produto produto) throws TipoChaveNaoEncontradaException {
        return produtoDao.cadastrar(produto);
    }

    @Override
    public Produto buscarPorCodigo(Long codigo) {
        return produtoDao.consultar(codigo);
    }

    @Override
    public Boolean excluir(Long codigo) {
        return produtoDao.excluir(codigo);
    }

    @Override
    public void alterar(Produto produto) throws TipoChaveNaoEncontradaException {
        produtoDao.alterar(produto);
    }
}
