package main.Java.dao;

import main.Java.dao.generics.GenericDAO;
import main.Java.domain.NotaFiscalDet;

public class NotaFiscalDetDao extends GenericDAO<NotaFiscalDet> implements INotaFiscalDetDao {

    public NotaFiscalDetDao() {
        super();
    }

    @Override
    public Class<NotaFiscalDet> getTipoClasse() {
        return NotaFiscalDet.class;
    }

    @Override
    public void atualiarDados(NotaFiscalDet entity, NotaFiscalDet entityCadastrado) {
        // TODO Auto-generated method stub

    }

}
