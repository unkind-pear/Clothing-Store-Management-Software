package bean;

public class Vestido extends Roupa {
	private String estampa;
	private String tipo;
	
	public Vestido(int cod, double preco, String estampa, String tipo) {
		super(cod, preco);
		this.estampa = estampa;
		this.tipo = tipo;
	}

	public String getEstampa() {
		return estampa;
	}

	public void setEstampa(String estampa) {
		this.estampa = estampa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Vestido|cod|"+cod+"|preco|"+preco+"|estampa|" + estampa + "|tipo|" + tipo;
	}
}
