package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Cliente;

public class ClienteDAO {
	private Connection connection;
	
	public ClienteDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Cliente c) {
		int inseriu = 0;
		String sql = "insert into clientes(nome) values(?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public ArrayList<Cliente> getLista() {
		String slq = "select * from calcas;";
		PreparedStatement stmt;
		Cliente c;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(slq);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cliente> cs = new ArrayList<>();
			while (rs.next()) {
				c = new Cliente(
					rs.getInt("cod"),
					rs.getString("nome")
				);
				cs.add(c);
			}
			rs.close();
			stmt.close();
			return cs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int remover(Cliente c) {
		int removeu = 0;
		String sql = "delete from clientes where cod=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, c.getCod());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int alterar(Cliente c) {
		int alterou = 0;
		String sql = "update clientes set nome=? where cod=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setInt(2, c.getCod());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
}
