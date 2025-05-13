package escriptures;

import java.io.Serial;

import escriptures.gènesi.Pare;

public class Verset extends Pare<Paraula,Nom> {
	@Serial
	private static final long serialVersionUID = 3134129150208197379L;

	@Override
	public String nom() {
		StringBuilder nom = new StringBuilder();
		for(Entrada<Paraula,Nom> entrada : entrada()) {
			nom.append(entrada.nom());
		}
		return nom.toString();
	}
	
	public Verset() {
		super();
	}
	public Verset(Gènere paritat) {
		super(paritat);
	}
	public Verset(Paraula clau, Nom valor) {
		super(Capítol.class, Gènere.qualsevol(), clau, valor);
	}
	public Verset(Verset pare) {
		super(pare);
	}
	public Verset(Verset pare, Paraula clau, Nom valor) {
		super(Capítol.class, pare, clau, valor);
	}
	public Verset(Verset senyor, Gènere paritat) {
		super(senyor, paritat);
	}
	public Verset(Verset senyor, Gènere paritat, Paraula clau, Nom valor) {
		super(Capítol.class, senyor, paritat, clau, valor);
	}
	
	@Override
	public int compareTo(Entrada<Nom,Paraula> o) {
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