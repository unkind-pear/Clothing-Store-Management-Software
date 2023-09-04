package principal;

import bean.Roupa;
import bean.Calca;
import bean.Camiseta;
import bean.Cliente;
import bean.Vestido;
import dao.CalcaDAO;
import dao.CamisetaDAO;
import dao.ClienteDAO;
import dao.CompraDAO;
import dao.VestidoDAO;

import java.util.ArrayList;

import bean.ArrayToString;

public class Principal {
	public static void main(String[] args) {
		Calca c1 = new Calca(3, 89.6, 44, "jeans");
		Calca c2 = new Calca(2, 78.98, 38, "jeans");
		Camiseta ca1 = new Camiseta(1, 45.8, 'M', "Azul");
		Vestido v1 = new Vestido(4, 1299.6, "listrado", "Tomara que caia");
		Cliente cli2 = new Cliente(2, "Xuxux");
		
//		ArrayList<Roupa> roupas = new ArrayList<>();
//		roupas.add(c1);
//		roupas.add(r1);
//		String r = ArrayToString.toStringRoupa(roupas);
//		System.out.println(r);
		
		CalcaDAO gc = new CalcaDAO();
		CamisetaDAO gca = new CamisetaDAO();
		VestidoDAO gv = new VestidoDAO();
		CompraDAO gcomp = new CompraDAO();
		ClienteDAO gcli = new ClienteDAO();
		
		//gc.inserir(c1);
//		gc.inserir(c2);
//		gca.inserir(ca1);
//		gv.inserir(v1);
		
//		gcli.inserir(cli2);
//		gcomp.inserir(cli2, c1);
		
		System.out.println(gc.getLista());
		ArrayList<Roupa> rapapa = gcomp.getComprasDeCliente(cli2);
		System.out.println(rapapa);
		System.out.println(rapapa.get(0) instanceof Calca);
		System.out.println(rapapa instanceof ArrayList);
	}
}
