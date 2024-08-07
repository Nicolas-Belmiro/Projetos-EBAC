package teste.java;

import main.java.dao.IProdutoDAO;
import main.java.dao.ProdutoDAO;
import main.java.domain.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class ProdutoTeste {
    private IProdutoDAO produtoDao;
     @Test
    public void cadastrarTest() throws Exception {
        this.produtoDao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setSku(100L);
        produto.setDescricao("Produto 100");
        produto.setUnidade("Pacote");
        produto.setValor_unitario(12.3);
        Integer regCadastro = this.produtoDao.cadastrar(produto);
        Assert.assertTrue(regCadastro == 1);
        Produto produtoBD = this.produtoDao.buscar(100L);
        Assert.assertNotNull(produtoBD);
        Assert.assertEquals(produto.getDescricao(), produtoBD.getDescricao());
        Integer regDel = this.produtoDao.excluir(produtoBD);
        Assert.assertTrue(regDel == 1);
    }

    @Test
    public void buscarTest() throws Exception {
        this.produtoDao = new ProdutoDAO();
        Produto produtoBD = this.produtoDao.buscar(100L);
        Assert.assertNull(produtoBD);
        Produto produto = new Produto();
        produto.setSku(100L);
        produto.setDescricao("Produto 100");
        produto.setUnidade("Unidade");
        produto.setValor_unitario(45.76);
        Integer countCad = this.produtoDao.cadastrar(produto);
        Assert.assertTrue(countCad == 1);
        produtoBD = this.produtoDao.buscar(100L);
        Assert.assertNotNull(produtoBD);
        Assert.assertEquals(produto.getSku(), produtoBD.getSku());
        Assert.assertEquals(produto.getDescricao(), produtoBD.getDescricao());
        Integer countDel = this.produtoDao.excluir(produtoBD);
        Assert.assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        this.produtoDao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setSku(300L);
        produto.setDescricao("Produto 300");
        produto.setUnidade("Unidade");
        produto.setValor_unitario(77.9);
        Integer countCad = this.produtoDao.cadastrar(produto);
        Assert.assertTrue(countCad == 1);
        Produto produtoBD = this.produtoDao.buscar(300L);
        Assert.assertNotNull(produtoBD);
        Assert.assertEquals(produto.getSku(), produtoBD.getSku());
        Assert.assertEquals(produto.getDescricao(), produtoBD.getDescricao());
        Integer countDel = this.produtoDao.excluir(produtoBD);
        Assert.assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        this.produtoDao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setSku(100L);
        produto.setDescricao("Produto 100");
        produto.setUnidade("Unidade");
        produto.setValor_unitario(21.45);
        Integer countCad = this.produtoDao.cadastrar(produto);
        Assert.assertTrue(countCad == 1);

        Produto produto2 = new Produto();
        produto2.setSku(200L);
        produto2.setDescricao("Produto 200");
        produto2.setUnidade("Unidade");
        produto2.setValor_unitario(776.98);
        Integer countCad2 = this.produtoDao.cadastrar(produto2);
        Assert.assertTrue(countCad2 == 1);

        List<Produto> list = this.produtoDao.buscarTodos();
        Assert.assertNotNull(list);
        Assert.assertEquals(2L, (long)list.size());
        int countDel = 0;

        for(Iterator var8 = list.iterator(); var8.hasNext(); ++countDel) {
            Produto prod = (Produto)var8.next();
            this.produtoDao.excluir(prod);
        }

        Assert.assertEquals((long)list.size(), (long)countDel);
        list = this.produtoDao.buscarTodos();
        Assert.assertEquals((long)list.size(), 0L);
    }

    @Test
    public void atualizarTest() throws Exception {
        this.produtoDao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setSku(100L);
        produto.setDescricao("Produto 100");
        produto.setUnidade("Unidade");
        produto.setValor_unitario(12.34);
        Integer countCad = this.produtoDao.cadastrar(produto);
        Assert.assertTrue(countCad == 1);
        Produto produtoBD = this.produtoDao.buscar(100L);
        Assert.assertNotNull(produtoBD);
        Assert.assertEquals(produto.getSku(), produtoBD.getSku());
        Assert.assertEquals(produto.getDescricao(), produtoBD.getDescricao());
        produtoBD.setSku(200L);
        produtoBD.setDescricao("Produto 200");
        produtoBD.setUnidade("Outra unidade");
        Integer countUpdate = this.produtoDao.atualizar(produtoBD);
        Assert.assertTrue(countUpdate == 1);
        Produto produtoBD1 = this.produtoDao.buscar(100L);
        Assert.assertNull(produtoBD1);
        Produto produtoBD2 = this.produtoDao.buscar(200L);
        Assert.assertNotNull(produtoBD2);
        Assert.assertEquals(produtoBD.getSku(), produtoBD2.getSku());
        Assert.assertEquals(produtoBD.getDescricao(), produtoBD2.getDescricao());
        List<Produto> list = this.produtoDao.buscarTodos();
        Iterator var9 = list.iterator();

        while(var9.hasNext()) {
            Produto prod = (Produto)var9.next();
            this.produtoDao.excluir(prod);
        }

    }
}
