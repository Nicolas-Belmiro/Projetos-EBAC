package teste.java.player;
import main.Java.dao.INotaFiscalDetDao;
import main.Java.domain.NotaFiscalDet;
import main.Java.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import teste.java.player.dao.NotaFiscalDetDaoMock;


public class NotaFiscalDetDaoTest {
    private INotaFiscalDetDao notaFiscalDetDao;
    private NotaFiscalDet notaFiscalDet;

    public NotaFiscalDetDaoTest() {
        notaFiscalDetDao = new NotaFiscalDetDaoMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        notaFiscalDet = new NotaFiscalDet();
        notaFiscalDet.setCodigoProdutoINF(987);
        notaFiscalDet.setNumeroNF(111L);
        notaFiscalDet.setQuantidadeINF(12);
        notaFiscalDet.setSequencialINF(1L);
        notaFiscalDet.setValorINF(2.5);
        notaFiscalDetDao.cadastrar(notaFiscalDet);
    }

    @Test
    public void pesquisarNotaFiscal() {
        NotaFiscalDet notaFiscalDetPesquisado = notaFiscalDetDao.consultar(notaFiscalDet.getNumeroNF());
        Assert.assertNotNull(notaFiscalDetPesquisado);
    }

    @Test
    public void salvaNotaFiscal() throws TipoChaveNaoEncontradaException {
        Boolean retorno = notaFiscalDetDao.cadastrar(notaFiscalDet);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirNotaFiscal() {
        Boolean retorno = notaFiscalDetDao.excluir(notaFiscalDet.getNumeroNF());
        Assert.assertTrue(retorno);
    }

    @Test
    public void alterarNotaFiscal() throws TipoChaveNaoEncontradaException {
        notaFiscalDet.setSequencialINF(2L);
        notaFiscalDetDao.alterar(notaFiscalDet);
        Assert.assertEquals( (Long) 2L, notaFiscalDet.getSequencialINF());
    }

}

