package escriptures;

import java.io.Serial;

import escriptures.gènesi.Pare;

public class Paraula extends Pare<Character,Integer> {
	@Serial
	private static final long serialVersionUID = 6012685735181316050L;

	@Override
	public String nom() {
		return null;
	}
	
	public Paraula() {
		super();
	}
	public Paraula(Gènere paritat) {
		super(paritat);
	}
	public Paraula(Gènere paritat, Character clau, Integer valor) {
		super(Nom.class, paritat, clau, valor);
	}
	public Paraula(Paraula pare) {
		super(pare);
	}
	public Paraula(Paraula pare, Character clau, Integer valor) {
		super(Nom.class, pare, clau, valor);
	}
	public Paraula(Paraula senyor, Gènere paritat) {
		super(senyor, paritat);
	}
	public Paraula(Paraula senyor, Gènere paritat, Character clau, Integer valor) {
		super(Nom.class, senyor, paritat, clau, valor);
	}
	
	@Override
	public int compareTo(Entrada<Integer, Character> o) {
		return 0;
	}
	@Override
	public void run() {
		
	}
}