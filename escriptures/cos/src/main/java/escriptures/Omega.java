package escriptures;

import escriptures.gènesi.Fill;

public class Omega extends Fill<Carta, Llibre> {

	private static final long serialVersionUID = 1365190070734532815L;

	@Override
	public String nom() {
		return null;
	}
	
	public Omega() {
		super();
	}
	public Omega(Gènere paritat) {
		super(paritat);
	}
	public Omega(Gènere paritat, Carta clau, Llibre valor) {
		super(Alfa.class, paritat, clau, valor);
	}
	public Omega(Omega pare) {
		super(pare);
	}
	public Omega(Omega pare, Carta clau, Llibre valor) {
		super(Alfa.class, pare, clau, valor);
	}
	public Omega(Omega sobirana, Gènere paritat) {
		super(sobirana, paritat);
	}
	public Omega(Omega sobirana, Gènere paritat, Carta clau, Llibre valor) {
		super(Alfa.class, sobirana, paritat, clau, valor);
	}

	@Override
	public int compareTo(Entrada<Llibre, Carta> o) {
		return 0;
	}
	@Override
	public void run() {
		
	}
}