package escriptures;

import java.io.Serial;

import escriptures.gènesi.Pare;

public class Llibre extends Pare<Passatge,Salm> {
	@Serial
	private static final long serialVersionUID = 3478199192095999588L;

	@Override
	public String nom() {
		StringBuilder nom = new StringBuilder();
		for(Entrada<Passatge,Salm> entrada : entrada()) {
			nom.append(entrada.nom());
		}
		return nom.toString();
	}

	public Llibre() {
		super();
	}
	public Llibre(Gènere paritat) {
		super(paritat);
	}
	public Llibre(Passatge clau, Salm valor) {
		super(Carta.class, Gènere.qualsevol(), clau, valor);
	}
	public Llibre(Llibre pare) {
		super(pare);
	}
	public Llibre(Llibre pare, Passatge clau, Salm valor) {
		super(Carta.class, pare, clau, valor);
	}
	public Llibre(Llibre senyor, Gènere paritat) {
		super(senyor, paritat);
	}
	public Llibre(Llibre senyor, Gènere paritat, Passatge clau, Salm valor) {
		super(Carta.class, senyor, paritat, clau, valor);
	}

	@Override
	public int compareTo(Entrada<Salm,Passatge> o) {
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
