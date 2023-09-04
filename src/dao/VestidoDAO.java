package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Vestido;

public class VestidoDAO {
	private Connection connection;
	
	public VestidoDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Vestido c) {
		int inseriu = 0;
		String sql = "insert into vestidos(preco, estampa, tipo) values(?,?,?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setDouble(1, c.getPreco());
			stmt.setString(2, c.getEstampa());
			stmt.setString(3, c.getTipo());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public ArrayList<Vestido> getLista() {
		String slq = "select * from vestidos;";
		PreparedStatement stmt;
		Vestido c;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(slq);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Vestido> cs = new ArrayList<>();
			while (rs.next()) {
				c = new Vestido(
					rs.getInt("cod"),
					rs.getDouble("preco"),
					rs.getString("estampa"),
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
	
	public int remover(Vestido c) {
		int removeu = 0;
		String sql = "delete from vestidos where cod=?;";
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
	
	public int alterar(Vestido c) {
		int alterou = 0;
		String sql = "update calcas set preco=?, estampa=?, tipo=? where cod=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setDouble(1, c.getPreco());
			stmt.setString(2, c.getEstampa());
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
