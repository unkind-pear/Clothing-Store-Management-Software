package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Calca;

public class CalcaDAO {
	private Connection connection;
	
	public CalcaDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Calca c) {
		int inseriu = 0;
		String sql = "insert into calcas(preco, tamanho, tipo) values(?,?,?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setDouble(1, c.getPreco());
			stmt.setInt(2, c.getTamanho());
			stmt.setString(3, c.getTipo());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public ArrayList<Calca> getLista() {
		String slq = "select * from calcas;";
		PreparedStatement stmt;
		Calca c;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(slq);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Calca> cs = new ArrayList<>();
			while (rs.next()) {
				c = new Calca(
					rs.getInt("cod"),
					rs.getDouble("preco"),
					rs.getInt("tamanho"),
					rs.getString("tipo")
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
	
	public int remover(Calca c) {
		int removeu = 0;
		String sql = "delete from calcas where cod=?;";
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
	
	public int alterar(Calca c) {
		int alterou = 0;
		String sql = "update calcas set preco=?, tamanho=?, tipo=? where cod=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setDouble(1, c.getPreco());
			stmt.setInt(2, c.getTamanho());
			stmt.setString(3, c.getTipo());
			stmt.setInt(4, c.getCod());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
}
