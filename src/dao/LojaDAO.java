package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Loja;

public class LojaDAO {
	private Connection connection;
	
	public LojaDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Loja c) {
		int inseriu = 0;
		String sql = "insert into loja(nome, endereco) values(?,?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEndereco());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public Loja getLoja() {
		String slq = "select * from loja;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(slq);
			ResultSet rs = stmt.executeQuery();
			Loja cs = new Loja(rs.getInt("cod"), rs.getString("nome"), rs.getString("endereco"));
			rs.close();
			stmt.close();
			return cs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int remover(Loja c) {
		int removeu = 0;
		String sql = "delete from loja where cod=?;";
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
	
	public int alterar(Loja c) {
		int alterou = 0;
		String sql = "update loja set nome=?, endereco=? where cod=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEndereco());
			stmt.setInt(3, c.getCod());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
}
