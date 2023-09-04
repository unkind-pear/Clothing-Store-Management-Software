package bean;

public class Calca extends Roupa {
	private int tamanho;
	private String tipo;
	
	public Calca(int cod, double preco, int tamanho, String tipo) {
		super(cod, preco);
		this.tamanho = tamanho;
		this.tipo = tipo;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Calca|cod|"+cod+"|preco|"+preco+"|tamanho|" + tamanho + "|tipo|" + tipo;
	}
}
