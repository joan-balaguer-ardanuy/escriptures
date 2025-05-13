package escriptures;

import java.io.Serial;

import escriptures.gènesi.Fill;

public class Nom extends Fill<Integer,Character> {
	@Serial
	private static final long serialVersionUID = 4719316508845658502L;

	@Override
	public String nom() {
		StringBuilder nom = new StringBuilder();
		for(Entrada<Integer,Character> entrada : this) {
			nom.append(entrada.elValor());
		}
		return nom.toString();
	}

	public Nom() {
		super();
	}
	public Nom(Gènere paritat) {
		super(paritat);
	}
	public Nom(Integer clau, Character valor) {
		super(Paraula.class, Gènere.qualsevol(), clau, valor);
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
	public int compareTo(Entrada<Character,Integer> o) {
		return 0;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(laClau());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		super.run();
	}
}