package main.java.dao;

import main.java.dao.generic_jdbc.GenericDAO;
import main.java.domain.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO() {
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
        entityCadastrado.setCidade(entity.getCidade());
        entityCadastrado.setCpf(entity.getCpf());
        entityCadastrado.setEnd(entity.getEnd());
        entityCadastrado.setEstado(entity.getEstado());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setNumero(entity.getNumero());
        entityCadastrado.setTel(entity.getTel());
        entityCadastrado.setGenero(entity.getGenero());

    }

    @Override
    protected String getQueryInsercao() {
        String sb = "INSERT INTO TB1_CLIENTE " +
                "(ID, NOME, CPF, TEL, ENDERECO, NUMERO, CIDADE, ESTADO, GENERO)" +
                " VALUES (nextval('sq_cliente'),?,?,?,?,?,?,?,?)";
        return sb;
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Cliente entity) throws SQLException {
        stmInsert.setString(1, entity.getNome());
        stmInsert.setLong(2, entity.getCpf());
        stmInsert.setLong(3, entity.getTel());
        stmInsert.setString(4, entity.getEnd());
        stmInsert.setLong(5, entity.getNumero());
        stmInsert.setString(6, entity.getCidade());
        stmInsert.setString(7, entity.getEstado());
        stmInsert.setString(8, entity.getGenero());
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB1_CLIENTE WHERE CPF = ?";
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long valor) throws SQLException {
        stmExclusao.setLong(1, valor);
    }

    @Override
    protected String getQueryAtualizacao() {
        String sb = "UPDATE TB1_CLIENTE " +
                "SET NOME = ?," +
                "TEL = ?," +
                "ENDERECO = ?," +
                "NUMERO = ?," +
                "CIDADE = ?," +
                "ESTADO = ?," +
                "GENERO = ?" +
                " WHERE CPF = ?";
        return sb;
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Cliente entity) throws SQLException {
        stmUpdate.setString(1, entity.getNome());
        stmUpdate.setLong(2, entity.getTel());
        stmUpdate.setString(3, entity.getEnd());
        stmUpdate.setLong(4, entity.getNumero());
        stmUpdate.setString(5, entity.getCidade());
        stmUpdate.setString(6, entity.getEstado());
        stmUpdate.setString(7, entity.getGenero());
        stmUpdate.setLong(8, entity.getCpf());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {
        stmSelect.setLong(1, valor);
    }

}