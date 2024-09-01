package main.java.services;


import main.java.dao.IProdutoDAO;
import main.java.domain.Produto;
import main.java.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}