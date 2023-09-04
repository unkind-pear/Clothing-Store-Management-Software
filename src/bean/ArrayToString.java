package bean;

import java.util.ArrayList;

public class ArrayToString {
	public static String toStringRoupa(ArrayList<Roupa> roupas) {
		String stringLista = null;
		for (Roupa roupa : roupas) {
			stringLista = stringLista+roupa.toString();
		}
		return stringLista;
	}
	
	public static Roupa stringToRoupa(String s) {
		String[] str = s.split("|");
			switch (str[0]) {
			case "Calca": {
				int a = Integer.parseInt(str[2]);
				double b = Double.parseDouble(str[4]);
				int c = Integer.parseInt(str[6]);
				String d = str[8];
				Calca ca = new Calca(a, b, c, d);
				return ca;
			}
			case "Camiseta": {
				int a = Integer.parseInt(str[2]);
				double b = Double.parseDouble(str[4]);
				char c = str[6].charAt(0);
				String d = str[8];
				Camiseta ca = new Camiseta(a, b, c, d);
				return ca;
			}
			case "Vestido": {
				int a = Integer.parseInt(str[2]);
				double b = Double.parseDouble(str[4]);
				String c = str[6];
				String d = str[8];
				Vestido ca = new Vestido(a, b, c, d);
				return ca;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + str[0]);
			}
	}
}
