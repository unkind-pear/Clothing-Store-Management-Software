package bean;

import java.util.ArrayList;

public class Cliente {
	private int cod;
	private String nome;
	private ArrayList<Roupa> compras = new ArrayList<>();
	
	public Cliente(int cod, String nome) {
		super();
		this.cod = cod;
		this.nome = nome;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Roupa> getCompras() {
		return compras;
	}
	public void setCompras(ArrayList<Roupa> compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		return "Cliente [cod=" + cod + ", nome=" + nome + ", compras=" + compras + "]";
	}
}
