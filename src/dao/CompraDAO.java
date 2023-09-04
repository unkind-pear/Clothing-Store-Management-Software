package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Roupa;
import bean.ArrayToString;
import bean.Cliente;

public class CompraDAO {
	private Connection connection;
	
	public CompraDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Cliente c, Roupa r) {
		int inseriu = 0;
		String sql = "insert into produtosComprados(codCliente, produto) values(?,?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, c.getCod());
			stmt.setString(2, r.toString());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public ArrayList<Roupa> getComprasDeCliente(Cliente c) {
		String slq = "select * from produtosComprados;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(slq);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Roupa> rps = new ArrayList<>();
			while (rs.next()) {
				if (rs.getInt("codCliente") == c.getCod()) {
					rps.add(ArrayToString.stringToRoupa(rs.getString("produto")));
				}
			}
			rs.close();
			stmt.close();
			return rps;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int remover(int c) {
		int removeu = 0;
		String sql = "delete from produtosComprados where cod=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, c);
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int alterar(Cliente c, Roupa r) {
		int alterou = 0;
		String sql = "update produtosComprados set nome=?, produto=? where cod=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, r.toString());
			stmt.setInt(3, c.getCod());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
}
