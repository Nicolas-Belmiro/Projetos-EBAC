package main.Java.dao;

import main.Java.dao.generics.GenericDAO;
import main.Java.domain.Produto;

public class ProdutoDao extends GenericDAO<Produto> implements IProdutoDao{

    public ProdutoDao() {
        super();
    }

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualiarDados(Produto entity, Produto entityCadastrado) {
        // TODO Auto-generated method stub

    }
}
