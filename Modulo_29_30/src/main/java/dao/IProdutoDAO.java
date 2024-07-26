package main.java.dao;

import main.java.domain.Produto;

import java.util.List;

public interface IProdutoDAO {


        public Integer cadastrar(Produto produto) throws Exception;

        public Integer atualizar(Produto produto) throws Exception;

        public Produto buscar(Long sku) throws Exception;

        public List<Produto> buscarTodos() throws Exception;

        public Integer excluir(Produto produto) throws Exception;

}
