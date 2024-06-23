package teste.java.player;
import main.Java.dao.IProdutoDao;
import main.Java.domain.Produto;
import main.Java.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import teste.java.player.dao.ProdutoDaoMock;


public class ProdutoDaoTest {
    private IProdutoDao produtoDao;
    private Produto produto;

    public ProdutoDaoTest() {
        produtoDao = (IProdutoDao) new ProdutoDaoMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        produto = new Produto();
        produto.setCodigo(123L);
        produto.setDescricao("Produto teste");
        produto.setUnidadeMedida("Unidade");
        produto.setValorUnitario(12.35);
        produtoDao.cadastrar(produto);
    }

    @Test
    public void pesquisarProduto() {
        Produto produtoConsultado = produtoDao.consultar(produto.getCodigo());
        Assert.assertNotNull(produtoConsultado);
    }

    @Test
    public void salvarProduto() throws TipoChaveNaoEncontradaException {
        Boolean retorno = produtoDao.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirProduto() {
        Boolean retorno = produtoDao.excluir(produto.getCodigo());
        Assert.assertTrue(retorno);
    }

    @Test
    public void alterarProduto() throws TipoChaveNaoEncontradaException {
        produto.setDescricao("Produto teste versão 3");
        produtoDao.alterar(produto);
        Assert.assertEquals("Produto teste versão 3",produto.getDescricao());
    }
}
