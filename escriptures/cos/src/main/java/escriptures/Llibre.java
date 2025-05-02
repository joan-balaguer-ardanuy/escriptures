package escriptures;

import java.io.Serial;

import escriptures.gènesi.Pare;

public class Llibre extends Pare<Passatge,Salm> {
	@Serial
	private static final long serialVersionUID = 3478199192095999588L;

	@Override
	public String nom() {
		return null;
	}

	public Llibre() {
		super();
	}
	public Llibre(Gènere paritat) {
		super(paritat);
	}
	public Llibre(Gènere paritat, Passatge clau, Salm valor) {
		super(Carta.class, paritat, clau, valor);
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
		
	}
}
