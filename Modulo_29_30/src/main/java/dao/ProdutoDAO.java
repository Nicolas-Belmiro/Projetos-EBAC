package main.java.dao;

import main.java.dao.generic_jdbc.ConnectionFactory;
import main.java.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = (Connection) ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            stm = connection.prepareStatement(sql);
            adicionarParametrosInsert(stm, produto);
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Produto buscar(Long sku) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            con = (Connection) ConnectionFactory.getConnection();
            String sql = getSqlSelect();
            stm = ((java.sql.Connection) con).prepareStatement(sql);
            adicionarParametrosSelect(stm, sku);
            rs = stm.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getLong("ID"));
                produto.setSku(rs.getLong("SKU"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setUnidade(rs.getString("UNIDADE"));
                produto.setValor_unitario(rs.getDouble("VALOR_UNITARIO"));
            }

        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(con, stm, rs);
        }
        return produto;
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = (Connection) ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            stm = ((java.sql.Connection) con).prepareStatement(sql);
            adicionarParametrosDelete(stm, produto);
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(con, stm, null);
        }
    }


    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Produto> list = new ArrayList<>();
        Produto produto = null;
        try {
            connection = (Connection) ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            stm = ((java.sql.Connection) connection).prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                Long id = rs.getLong("ID");
                Long sku = rs.getLong("SKU");
                String descricao = rs.getString("DESCRICAO");
                String unidade = rs.getString("UNIDADE");
                Double valor_unitario = rs.getDouble("VALOR_UNITARIO");
                produto.setId(id);
                produto.setSku(sku);
                produto.setDescricao(descricao);
                produto.setUnidade(unidade);
                produto.setValor_unitario(valor_unitario);

                list.add(produto);
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
        sb.append("SELECT * FROM PRODUTO ");
        return sb.toString();
    }

    private void adicionarParametrosDelete(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setLong(1, produto.getSku());
    }

    private String getSqlDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM PRODUTO ");
        sb.append("WHERE SKU = ?");
        return sb.toString();
    }

    private void adicionarParametrosSelect(PreparedStatement stm, Long sku) throws SQLException {
        stm.setLong(1, sku);
    }

    private String getSqlSelect() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM PRODUTO ");
        sb.append("WHERE SKU = ? ");
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


    private void adicionarParametrosInsert(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setLong(1, produto.getSku());
        stm.setString(2, produto.getDescricao());
        stm.setString(3, produto.getUnidade());
        stm.setDouble(4, produto.getValor_unitario());

    }

    private String getSqlInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO PRODUTO (ID,SKU,DESCRICAO,UNIDADE,VALOR_UNITARIO) ");
        sb.append("VALUES (nextval('SQ_PRODUTO'),?,?,?,?)");
        return sb.toString();
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = (Connection) ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            stm = connection.prepareStatement(sql);
            adicionarParametrosUpdate(stm, produto);
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    private void adicionarParametrosUpdate(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setLong(1, produto.getSku());
        stm.setString(2, produto.getDescricao());
        stm.setString(3, produto.getUnidade());
        stm.setDouble(4, produto.getValor_unitario());
        stm.setDouble(5, produto.getId());
    }

    private String getSqlUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE PRODUTO ");
        sb.append("SET SKU = ?, DESCRICAO = ?, UNIDADE = ?, VALOR_UNITARIO = ? ");
        sb.append("WHERE ID = ?");
        return sb.toString();
    }





}
