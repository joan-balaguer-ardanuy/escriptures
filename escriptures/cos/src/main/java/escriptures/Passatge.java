package escriptures;

import java.io.Serial;

import escriptures.gènesi.Pare;

public class Passatge extends Pare<Verset,Capítol> {
	@Serial
	private static final long serialVersionUID = 1037425553052355272L;

	@Override
	public String nom() {
		StringBuilder nom = new StringBuilder();
		for(Entrada<Verset,Capítol> entrada : entrada()) {
			nom.append(entrada.nom());
		}
		return nom.toString();
	}

	public Passatge() {
		super();
	}
	public Passatge(Gènere paritat) {
		super(paritat);
	}
	public Passatge(Verset clau, Capítol valor) {
		super(Salm.class, Gènere.qualsevol(), clau, valor);
	}
	public Passatge(Passatge pare) {
		super(pare);
	}
	public Passatge(Passatge pare, Verset clau, Capítol valor) {
		super(Salm.class, pare, clau, valor);
	}
	public Passatge(Passatge senyor, Gènere paritat) {
		super(senyor, paritat);
	}
	public Passatge(Passatge senyor, Gènere paritat, Verset clau, Capítol valor) {
		super(Salm.class, senyor, paritat, clau, valor);
	}

	@Override
	public int compareTo(Entrada<Capítol,Verset> o) {
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