package escriptures;

import java.io.Serial;

import escriptures.gènesi.Fill;

public class Capítol extends Fill<Nom,Paraula> {
	@Serial
	private static final long serialVersionUID = -6766587512216856048L;

	@Override
	public String nom() {
		return null;
	}

	public Capítol() {
		super();
	}
	public Capítol(Gènere paritat) {
		super(paritat);
	}
	public Capítol(Nom clau, Paraula valor) {
		super(Verset.class, Gènere.qualsevol(), clau, valor);
	}
	public Capítol(Capítol pare) {
		super(pare);
	}
	public Capítol(Capítol pare, Nom clau, Paraula valor) {
		super(Verset.class, pare, clau, valor);
	}
	public Capítol(Capítol sobirana, Gènere paritat) {
		super(sobirana, paritat);
	}
	public Capítol(Capítol sobirana, Gènere paritat, Nom clau, Paraula valor) {
		super(Verset.class, sobirana, paritat, clau, valor);
	}

	@Override
	public int compareTo(Entrada<Paraula,Nom> o) {
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