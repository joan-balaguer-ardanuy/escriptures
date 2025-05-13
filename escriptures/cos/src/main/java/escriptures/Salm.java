package escriptures;

import java.io.Serial;

import escriptures.gènesi.Fill;

public class Salm extends Fill<Capítol,Verset> {
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
	public Salm(Capítol clau, Verset valor) {
		super(Passatge.class, Gènere.qualsevol(), clau, valor);
	}
	public Salm(Salm pare) {
		super(pare);
	}
	public Salm(Salm pare, Capítol clau, Verset valor) {
		super(Passatge.class, pare, clau, valor);
	}
	public Salm(Salm sobirana, Gènere paritat) {
		super(sobirana, paritat);
	}
	public Salm(Salm sobirana, Gènere paritat, Capítol clau, Verset valor) {
		super(Passatge.class, sobirana, paritat, clau, valor);
	}

	@Override
	public int compareTo(Entrada<Verset, Capítol> o) {
		return 0;
	}
	@Override
	public void run() {
		for(Runnable entrada : laClau()) {
			entrada.run();
		}
		super.run();
	}
}