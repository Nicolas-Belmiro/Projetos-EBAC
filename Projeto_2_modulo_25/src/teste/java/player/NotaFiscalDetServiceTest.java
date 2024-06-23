package teste.java.player;
import main.Java.dao.INotaFiscalDetDao;
import main.Java.domain.NotaFiscalDet;
import main.Java.exception.TipoChaveNaoEncontradaException;
import main.Java.services.INotaFiscalDetService;
import main.Java.services.NotaFiscalDetService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import teste.java.player.dao.NotaFiscalDetDaoMock;


public class NotaFiscalDetServiceTest {
    private INotaFiscalDetService notaFiscalDetService;
    private NotaFiscalDet notaFiscalDet;

    public NotaFiscalDetServiceTest() {
        INotaFiscalDetDao dao = new NotaFiscalDetDaoMock();
        notaFiscalDetService = new NotaFiscalDetService(dao);
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        notaFiscalDet = new NotaFiscalDet();
        notaFiscalDet.setCodigoProdutoINF(987);
        notaFiscalDet.setNumeroNF(111L);
        notaFiscalDet.setQuantidadeINF(12);
        notaFiscalDet.setSequencialINF(1L);
        notaFiscalDet.setValorINF(2.5);
        notaFiscalDetService.salvar(notaFiscalDet);
    }

    @Test
    public void pesquisarNotaFiscal() {
        NotaFiscalDet notaFiscalDetPesquisado = notaFiscalDetService.buscarPorCodigo(notaFiscalDet.getNumeroNF());
        Assert.assertNotNull(notaFiscalDetPesquisado);
    }

    @Test
    public void salvaNotaFiscal() throws TipoChaveNaoEncontradaException {
        Boolean retorno = notaFiscalDetService.salvar(notaFiscalDet);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirNotaFiscal() {
        Boolean retorno = notaFiscalDetService.excluir(notaFiscalDet.getNumeroNF());
        Assert.assertTrue(retorno);
    }

    @Test
    public void alterarNotaFiscal() throws TipoChaveNaoEncontradaException {
        notaFiscalDet.setQuantidadeINF(13);
        notaFiscalDetService.alterar(notaFiscalDet);
        Assert.assertEquals( (Integer)13, notaFiscalDet.getQuantidadeINF());
    }


}
