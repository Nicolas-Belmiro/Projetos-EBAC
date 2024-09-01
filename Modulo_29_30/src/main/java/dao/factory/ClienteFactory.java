package main.java.dao.factory;

import main.java.domain.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteFactory {

    public static Cliente convert(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getLong("ID_CLIENTE"));
        cliente.setNome(rs.getString(("NOME")));
        cliente.setCpf(rs.getLong(("CPF")));
        cliente.setTel(rs.getLong(("TEL")));
        cliente.setEnd(rs.getString(("ENDERECO")));
        cliente.setNumero(rs.getInt(("NUMERO")));
        cliente.setCidade(rs.getString(("CIDADE")));
        cliente.setEstado(rs.getString(("ESTADO")));
        cliente.setGenero(rs.getString("GENERO"));
        return cliente;
    }
}