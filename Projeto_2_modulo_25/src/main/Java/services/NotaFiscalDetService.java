package main.Java.services;

import main.Java.dao.INotaFiscalDetDao;
import main.Java.domain.NotaFiscalDet;
import main.Java.exception.TipoChaveNaoEncontradaException;

public class NotaFiscalDetService  implements INotaFiscalDetService{

    private INotaFiscalDetDao notaFiscalDetDao;

    public NotaFiscalDetService(INotaFiscalDetDao notaFiscalDetDao) {
        this.notaFiscalDetDao = notaFiscalDetDao;
    }

    @Override
    public Boolean salvar(NotaFiscalDet notaFiscalDet) throws TipoChaveNaoEncontradaException {
        return notaFiscalDetDao.cadastrar(notaFiscalDet);
    }

    @Override
    public NotaFiscalDet buscarPorCodigo(Long numeroNF) {
        return notaFiscalDetDao.consultar(numeroNF);
    }

    @Override
    public Boolean excluir(Long numeroNF) {
        return notaFiscalDetDao.excluir(numeroNF);
    }

    @Override
    public void alterar(NotaFiscalDet notaFiscalDet) throws TipoChaveNaoEncontradaException {
        notaFiscalDetDao.alterar(notaFiscalDet);
    }
}
