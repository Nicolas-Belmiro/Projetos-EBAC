package main.java.dao;


import com.sun.jdi.connect.spi.Connection;
import main.java.dao.generic_jdbc.ConnectionFactory;
import main.java.domain.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = (Connection) ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            stm = connection.prepareStatement(sql);
            adicionarParametrosInsert(stm, cliente);
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Integer atualizar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = (Connection) ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            stm = connection.prepareStatement(sql);
            adicionarParametrosUpdate(stm, cliente);
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Cliente buscar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Cliente cliente = null;
        try {
            connection = (Connection) ConnectionFactory.getConnection();
            String sql = getSqlSelect();
            stm = connection.prepareStatement(sql);
            adicionarParametrosSelect(stm, codigo);
            rs = stm.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                Long codigo2 = rs.getLong("CODIGO");
                String cpf = rs.getString("CPF");
                String nome = rs.getString("NOME");
                String endereco = rs.getString("ENDERECO");
                String cidade = rs.getString("CIDADE");
                String estado = rs.getString("ESTADO");
                cliente.setCodigo(codigo2);
                cliente.setCpf(cpf);
                cliente.setNome(nome);
                cliente.setEndereco(endereco);
                cliente.setCidade(cidade);
                cliente.setEstado(estado);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, rs);
        }
        return cliente;
    }

    @Override
    public Integer excluir(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = (Connection) ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            stm = connection.prepareStatement(sql);
            adicionarParametrosDelete(stm, cliente);
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public List<Cliente> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Cliente> list = new ArrayList<>();
        Cliente cliente = null;
        try {
            connection = (Connection) ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                Long id = rs.getLong("CODIGO");
                String nome = rs.getString("NOME");
                String cpf = rs.getString("CPF");
                String endereco = rs.getString("ENDERECO");
                String cidade = rs.getString("CIDADE");
                String estado = rs.getString("ESTADO");
                cliente.setCodigo(id);
                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setEndereco(endereco);
                cliente.setCidade(cidade);
                cliente.setEstado(estado);

                list.add(cliente);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, rs);
        }
        return list;
    }

    private String getSqlSelectAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM CLIENTE");
        return sb.toString();
    }

    private void adicionarParametrosDelete(PreparedStatement stm, Cliente cliente) throws SQLException {
        stm.setString(1, cliente.getCpf());
    }

    private String getSqlDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM CLIENTE ");
        sb.append("WHERE CPF = ?");
        return sb.toString();
    }

    private void adicionarParametrosSelect(PreparedStatement stm, String codigo) throws SQLException {
        stm.setString(1, codigo);
    }

    private String getSqlSelect() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM CLIENTE ");
        sb.append("WHERE CPF = ?");
        return sb.toString();
    }

    private void adicionarParametrosUpdate(PreparedStatement stm, Cliente cliente) throws SQLException {
        stm.setString(1, cliente.getCpf());
        stm.setString(2, cliente.getNome());
        stm.setString(3, cliente.getEndereco());
        stm.setString(4, cliente.getCidade());
        stm.setString(5, cliente.getEstado());
        stm.setLong(6, cliente.getCodigo());
    }

    private String getSqlUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE CLIENTE ");
        sb.append("SET CPF = ?, NOME = ?, ENDERECO = ?, CIDADE = ?, ESTADO = ? ");
        sb.append("WHERE CODIGO = ?");
        return sb.toString();
    }

    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    private void adicionarParametrosInsert(PreparedStatement stm, Cliente cliente) throws SQLException {
        stm.setString(1, cliente.getCpf());
        stm.setString(2, cliente.getNome());
        stm.setString(3, cliente.getEndereco());
        stm.setString(4, cliente.getCidade());
        stm.setString(5, cliente.getEstado());
    }

    private String getSqlInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO CLIENTE (CODIGO,CPF,NOME,ENDERECO,CIDADE,ESTADO) ");
        sb.append("VALUES (nextval('SQ_CLIENTE'),?,?,?,?,?)");
        return sb.toString();
    }
}