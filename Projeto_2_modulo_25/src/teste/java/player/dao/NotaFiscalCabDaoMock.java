package teste.java.player.dao;

import main.Java.domain.NotaFiscalCab;
import main.Java.exception.TipoChaveNaoEncontradaException;

import java.util.Collection;



public class NotaFiscalCabDaoMock n{

    @Override
    public Boolean cadastrar(NotaFiscalCab entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public Boolean excluir(Long valor) {
        return true;
    }

    @Override
    public void alterar(NotaFiscalCab entity) throws TipoChaveNaoEncontradaException {
    }

    @Override
    public NotaFiscalCab consultar(Long valor) {
        NotaFiscalCab notaFiscalCab = new NotaFiscalCab();
        notaFiscalCab.setNumeroNF(valor);
        return notaFiscalCab;
    }

    @Override
    public Collection<NotaFiscalCab> buscarTodos() {
        return null;
    }
}
