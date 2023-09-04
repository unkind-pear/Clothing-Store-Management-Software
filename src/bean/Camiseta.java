package bean;

public class Camiseta extends Roupa {
	private char tamanho;
	private String cor;
	
	public Camiseta(int cod, double preco, char tamanho, String cor) {
		super(cod, preco);
		this.tamanho = tamanho;
		this.cor = cor;
	}
	
	public char getTamanho() {
		return tamanho;
	}
	public void setTamanho(char tamanho) {
		this.tamanho = tamanho;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	@Override
	public String toString() {
		return "Camiseta|cod|"+cod+"|preco|"+preco+"|tamanho|" + tamanho + "|cor|" + cor;
	}
}
