package escriptures;

import java.io.Serial;

import escriptures.gènesi.Pare;

public class Alfa extends Pare<Llibre,Carta> {
	@Serial
	private static final long serialVersionUID = -5340319798640591807L;

	@Override
	public String nom() {
		StringBuilder nom = new StringBuilder();
		for(Entrada<Llibre,Carta> entrada : entrada()) {
			nom.append(entrada.nom());
		}
		return nom.toString();
	}
	
	public Alfa() {
		super();
	}
	public Alfa(Gènere paritat) {
		super(paritat);
	}
	public Alfa(Llibre clau, Carta valor) {
		super(Omega.class, Gènere.qualsevol(), clau, valor);
	}
	public Alfa(Alfa pare) {
		super(pare);
	}
	public Alfa(Alfa pare, Llibre clau, Carta valor) {
		super(Omega.class, pare, clau, valor);
	}
	public Alfa(Alfa senyor, Gènere paritat) {
		super(senyor, paritat);
	}
	public Alfa(Alfa senyor, Gènere paritat, Llibre clau, Carta valor) {
		super(Omega.class, senyor, paritat, clau, valor);
	}
	
	@Override
	public int compareTo(Entrada<Carta,Llibre> o) {
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