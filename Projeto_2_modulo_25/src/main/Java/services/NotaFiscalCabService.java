package main.Java.services;

import main.Java.dao.INotaFiscalCabDao;
import main.Java.domain.NotaFiscalCab;
import main.Java.exception.TipoChaveNaoEncontradaException;

public class NotaFiscalCabService implements INotaFiscalCabService {

    private INotaFiscalCabDao notaFiscalCabDao;

    public NotaFiscalCabService(INotaFiscalCabDao notaFiscalCabDao) {
        this.notaFiscalCabDao = notaFiscalCabDao;
    }

    @Override
    public Boolean salvar(NotaFiscalCab notaFiscalCab) throws TipoChaveNaoEncontradaException {
        return notaFiscalCabDao.cadastrar(notaFiscalCab);
    }

    @Override
    public NotaFiscalCab buscarPorCodigo(Long numeroNF) {
        return notaFiscalCabDao.consultar(numeroNF);
    }

    @Override
    public Boolean excluir(Long numeroNF) {
        return notaFiscalCabDao.excluir(numeroNF);
    }

    @Override
    public void alterar(NotaFiscalCab notaFiscalCab) throws TipoChaveNaoEncontradaException {
        notaFiscalCabDao.alterar(notaFiscalCab);
    }

}
