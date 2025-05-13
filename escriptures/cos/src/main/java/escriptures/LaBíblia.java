package escriptures;

import java.io.Serial;

import escriptures.gènesi.Pare;

public class LaBíblia extends Pare<Alfa,Omega> {
	@Serial
	private static final long serialVersionUID = 3640331657208331844L;

	@Override
	public String nom() {
		StringBuilder nom = new StringBuilder();
		for(Entrada<Alfa,Omega> entrada : entrada()) {
			nom.append(entrada.nom());
		}
		return nom.toString();
	}

	public LaBíblia() {
		super();
	}
	public LaBíblia(Gènere paritat) {
		super(paritat);
	}
	public LaBíblia(Alfa clau, Omega valor) {
		super(Escriptures.class, Gènere.qualsevol(), clau, valor);
	}
	public LaBíblia(LaBíblia pare) {
		super(pare);
	}
	public LaBíblia(LaBíblia pare, Alfa clau, Omega valor) {
		super(Escriptures.class, pare, clau, valor);
	}
	public LaBíblia(LaBíblia senyor, Gènere paritat) {
		super(senyor, paritat);
	}
	public LaBíblia(LaBíblia senyor, Gènere paritat, Alfa clau, Omega valor) {
		super(Escriptures.class, senyor, paritat, clau, valor);
	}
	
	@Override
	public int compareTo(Entrada<Omega,Alfa> o) {
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