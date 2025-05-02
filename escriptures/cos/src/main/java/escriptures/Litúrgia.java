package escriptures;

import java.io.Serial;

import escriptures.gènesi.Fill;

public class Litúrgia extends Fill<Nom,Paraula> {

	@Serial
	private static final long serialVersionUID = -6766587512216856048L;

	@Override
	public String nom() {
		return null;
	}

	public Litúrgia() {
		super();
	}
	public Litúrgia(Gènere paritat) {
		super(paritat);
	}
	public Litúrgia(Gènere paritat, Nom clau, Paraula valor) {
		super(Verset.class, paritat, clau, valor);
	}
	public Litúrgia(Litúrgia pare) {
		super(pare);
	}
	public Litúrgia(Litúrgia pare, Nom clau, Paraula valor) {
		super(Verset.class, pare, clau, valor);
	}
	public Litúrgia(Litúrgia sobirana, Gènere paritat) {
		super(sobirana, paritat);
	}
	public Litúrgia(Litúrgia sobirana, Gènere paritat, Nom clau, Paraula valor) {
		super(Verset.class, sobirana, paritat, clau, valor);
	}

	@Override
	public int compareTo(Entrada<Paraula,Nom> o) {
		return 0;
	}
	@Override
	public void run() {
		
	}
}
