package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Camiseta;

public class CamisetaDAO {
	private Connection connection;
	
	public CamisetaDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Camiseta c) {
		int inseriu = 0;
		String sql = "insert into camisetas(preco, tamanho, cor) values(?,?,?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setDouble(1, c.getPreco());
			stmt.setString(2, Character.toString(c.getTamanho()));
			stmt.setString(3, c.getCor());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public ArrayList<Camiseta> getLista() {
		String slq = "select * from camisetas;";
		PreparedStatement stmt;
		Camiseta c;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(slq);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Camiseta> cs = new ArrayList<>();
			while (rs.next()) {
				c = new Camiseta(
					rs.getInt("cod"),
					rs.getDouble("preco"),
					rs.getString("tamanho").charAt(0),
					rs.getString("cor")
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
	
	public int remover(Camiseta c) {
		int removeu = 0;
		String sql = "delete from camisetas where cod=?;";
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
	
	public int alterar(Camiseta c) {
		int alterou = 0;
		String sql = "update camisetas set preco=?, tamanho=?, cor=? where cod=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setDouble(1, c.getPreco());
			stmt.setString(2, Character.toString(c.getTamanho()));
			stmt.setString(3, c.getCor());
			stmt.setInt(4, c.getCod());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
}
