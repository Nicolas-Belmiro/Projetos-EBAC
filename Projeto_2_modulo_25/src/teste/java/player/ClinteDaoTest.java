package teste.java.player;

import main.Java.dao.IClienteDao;
import main.Java.domain.Cliente;
import main.Java.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import teste.java.player.dao.ClienteDaoMock;


public class ClinteDaoTest {
    private IClienteDao clienteDao;
    private Cliente cliente;

    public ClinteDaoTest() {
        clienteDao = new ClienteDaoMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        //antes de todos os testes, executa este método
        cliente = new Cliente();
        cliente.setCpf(12345678901L);
        cliente.setNome("Nicolas");
        cliente.setCidade("São Paulo");
        cliente.setEstado("São Paulo");
        cliente.setEnd("Bom Sucesso");
        cliente.setNumeroEnd(4103);
        cliente.setTel(11948525025L);
        clienteDao.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Nicolas Belmiro Oliveira");
        clienteDao.alterar(cliente);

        Assert.assertEquals("Nicolas Belmiro Oliveira",cliente.getNome());
    }

}
