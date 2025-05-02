package escriptures;

import java.io.Serial;

import escriptures.gènesi.Fill;

public class Nom extends Fill<Integer,Character> {
	@Serial
	private static final long serialVersionUID = 4719316508845658502L;

	@Override
	public String nom() {
		return null;
	}

	public Nom() {
		super();
	}
	public Nom(Gènere paritat) {
		super(paritat);
	}
	public Nom(Gènere paritat, Integer clau, Character valor) {
		super(Paraula.class, paritat, clau, valor);
	}
	public Nom(Nom pare) {
		super(pare);
	}
	public Nom(Nom pare, Integer clau, Character valor) {
		super(Paraula.class, pare, clau, valor);
	}
	public Nom(Nom sobirana, Gènere paritat) {
		super(sobirana, paritat);
	}
	public Nom(Nom sobirana, Gènere paritat, Integer clau, Character valor) {
		super(Paraula.class, sobirana, paritat, clau, valor);
	}

	@Override
	public int compareTo(Entrada<Character, Integer> o) {
		return 0;
	}
	@Override
	public void run() {
		
	}
}