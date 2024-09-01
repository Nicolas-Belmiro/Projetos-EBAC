package main.java.dao;

import main.java.dao.generic_jdbc.GenericDAO;
import main.java.domain.Produto;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

    public ProdutoDAO() {
        super();
    }

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualiarDados(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setDescricao(entity.getDescricao());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setValor(entity.getValor());
        entityCadastrado.setUnidade(entity.getUnidade());
    }

    @Override
    protected String getQueryInsercao() {
        String sb = "INSERT INTO TB1_PRODUTO " +
                "(ID, CODIGO, NOME, DESCRICAO, VALOR, UNIDADE)" +
                "VALUES (nextval('sq_produto'),?,?,?,?,?)";
        return sb;
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto entity) throws SQLException {
        stmInsert.setString(1, entity.getCodigo());
        stmInsert.setString(2, entity.getNome());
        stmInsert.setString(3, entity.getDescricao());
        stmInsert.setBigDecimal(4, entity.getValor());
        stmInsert.setString(5, entity.getUnidade());
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB1_PRODUTO WHERE CODIGO = ?";
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, String valor) throws SQLException {
        stmExclusao.setString(1, valor);
    }

    @Override
    protected String getQueryAtualizacao() {
        String sb = "UPDATE TB1_PRODUTO " +
                "SET CODIGO = ?," +
                "NOME = ?," +
                "DESCRICAO = ?," +
                "VALOR = ?," +
                "UNIDADE = ?" +
                " WHERE CODIGO = ?";
        return sb;
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto entity) throws SQLException {
        stmUpdate.setString(1, entity.getCodigo());
        stmUpdate.setString(2, entity.getNome());
        stmUpdate.setString(3, entity.getDescricao());
        stmUpdate.setBigDecimal(4, entity.getValor());
        stmUpdate.setString(5, entity.getUnidade());
        stmUpdate.setString(6, entity.getCodigo());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmExclusao, String valor) throws SQLException {
        stmExclusao.setString(1, valor);
    }

}