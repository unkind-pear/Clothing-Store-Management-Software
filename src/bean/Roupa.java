package bean;

public class Roupa {
	protected int cod;
	protected double preco;
	
	public Roupa(int cod, double preco) {
		super();
		this.cod = cod;
		this.preco = preco;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Roupa [cod=" + cod + ", preco=" + preco + "]";
	}
}
