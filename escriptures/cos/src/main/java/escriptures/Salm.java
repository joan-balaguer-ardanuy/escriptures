package escriptures;

import java.io.Serial;

import escriptures.gènesi.Fill;

public class Salm extends Fill<Litúrgia,Verset> {
	@Serial
	private static final long serialVersionUID = 719513200907348032L;

	@Override
	public String nom() {
		return null;
	}

	public Salm() {
		super();
	}
	public Salm(Gènere paritat) {
		super(paritat);
	}
	public Salm(Gènere paritat, Litúrgia clau, Verset valor) {
		super(Passatge.class, paritat, clau, valor);
	}
	public Salm(Salm pare) {
		super(pare);
	}
	public Salm(Salm pare, Litúrgia clau, Verset valor) {
		super(Passatge.class, pare, clau, valor);
	}
	public Salm(Salm sobirana, Gènere paritat) {
		super(sobirana, paritat);
	}
	public Salm(Salm sobirana, Gènere paritat, Litúrgia clau, Verset valor) {
		super(Passatge.class, sobirana, paritat, clau, valor);
	}

	@Override
	public int compareTo(Entrada<Verset, Litúrgia> o) {
		return 0;
	}
	@Override
	public void run() {
		
	}
}