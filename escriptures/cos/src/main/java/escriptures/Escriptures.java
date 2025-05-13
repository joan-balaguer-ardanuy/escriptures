package escriptures;

import escriptures.gènesi.Fill;

public class Escriptures extends Fill<Omega,Alfa> {

	private static final long serialVersionUID = 591510918654310155L;

	@Override
	public String nom() {
		StringBuilder nom = new StringBuilder();
		for(Entrada<Omega,Alfa> entrada : this) {
			nom.append(entrada.nom());
		}
		return nom.toString();
	}

	public Escriptures() {
		super();
	}
	public Escriptures(Gènere paritat) {
		super(paritat);
	}
	public Escriptures(Omega clau, Alfa valor) {
		super(LaBíblia.class, Gènere.qualsevol(), clau, valor);
	}
	public Escriptures(Escriptures pare) {
		super(pare);
	}
	public Escriptures(Escriptures pare, Omega clau, Alfa valor) {
		super(LaBíblia.class, pare, clau, valor);
	}
	public Escriptures(Escriptures sobirana, Gènere paritat) {
		super(sobirana, paritat);
	}
	public Escriptures(Escriptures sobirana, Gènere paritat, Omega clau, Alfa valor) {
		super(LaBíblia.class, sobirana, paritat, clau, valor);
	}

	@Override
	public int compareTo(Entrada<Alfa,Omega> o) {
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