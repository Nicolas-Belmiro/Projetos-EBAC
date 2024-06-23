package teste.java.player;

import main.Java.dao.INotaFiscalCabDao;
import main.Java.domain.NotaFiscalCab;
import main.Java.exception.TipoChaveNaoEncontradaException;
import main.Java.services.INotaFiscalCabService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import teste.java.player.dao.NotaFiscalCabDaoMock;

import java.util.Date;


public class NotaFiscalCabService {
    private INotaFiscalCabService notaFiscalCabService;
    private NotaFiscalCab notaFiscalCab;

    public NotaFiscalCabService() {
        INotaFiscalCabDao dao = (INotaFiscalCabDao) new NotaFiscalCabDaoMock();
        notaFiscalCabService = (INotaFiscalCabService) new NotaFiscalCabService();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        notaFiscalCab = new NotaFiscalCab();
        notaFiscalCab.setClienteNF("Cliente da nota fiscal");
        notaFiscalCab.setDescricaoNF("Descrição da nota fiscal");
        notaFiscalCab.setNumeroNF(111L);
        notaFiscalCab.setValorNF(123.45);
        notaFiscalCab.setDataNF(new Date());
        notaFiscalCabService.salvar(notaFiscalCab);
    }

    @Test
    public void pesquisarNotaFiscal() {
        NotaFiscalCab notaFiscalCabPesquisado = notaFiscalCabService.buscarPorCodigo(notaFiscalCab.getNumeroNF());
        Assert.assertNotNull(notaFiscalCabPesquisado);
    }

    @Test
    public void salvaNotaFiscal() throws TipoChaveNaoEncontradaException {
        Boolean retorno = notaFiscalCabService.salvar(notaFiscalCab);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirNotaFiscal() {
        Boolean retorno = notaFiscalCabService.excluir(notaFiscalCab.getNumeroNF());
        Assert.assertTrue(retorno);
    }

    @Test
    public void alterarNotaFiscal() throws TipoChaveNaoEncontradaException {
        notaFiscalCab.setClienteNF("Segundo cliente da nota fiscal");
        notaFiscalCabService.alterar(notaFiscalCab);
        Assert.assertEquals("Segundo cliente da nota fiscal", notaFiscalCab.getClienteNF());
    }







}
