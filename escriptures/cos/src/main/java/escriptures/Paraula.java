package escriptures;

import java.io.IOException;
import java.io.Serial;
import java.io.StringReader;

import escriptures.gènesi.Pare;

public class Paraula extends Pare<Character,Integer> {
	@Serial
	private static final long serialVersionUID = 6012685735181316050L;
	
	public static void main(String[] args) {
		Paraula paraula = Paraula.llegir("hola");
		System.out.println(paraula.nom());
	}
	
	public static final Paraula llegir(String cadena) {
		StringReader lector = new StringReader(cadena);
		try {
			int enter = lector.read();
			if(enter != -1) {
				Paraula paraula = new Paraula((char) enter, enter);
				for(enter = lector.read(); enter != -1; enter = lector.read()) {
					paraula = new Paraula(paraula, (char) enter, enter);
				}
				return paraula;
			}
		} catch (IOException e) {
			throw new Error();
		}
		return null;
	}

	@Override
	public String nom() {
		StringBuilder nom = new StringBuilder();
		for(Entrada<Character,Integer> entrada : entrada()) {
			nom.append(entrada.laClau());
		}
		return nom.toString();
	}
	
	public Paraula() {
		super();
	}
	public Paraula(Gènere paritat) {
		super(paritat);
	}
	public Paraula(Character clau, Integer valor) {
		super(Nom.class, Gènere.qualsevol(), clau, valor);
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
	public void testimoniatge(Testimoni font, Fet argument) {
		super.testimoniatge(font, argument);
		switch (argument.manament()) {
		case Precepte.VIDA:
			membre().procrear((Paraula) argument.font(), elFill());
			donarTestimoni(new Fet(membre().font()));
			break;
		default:
			break;
		}
	}
	@Override
	public int compareTo(Entrada<Integer,Character> o) {
		switch (paritat()) {
		case FEMELLA:
			if (elValor() > o.laClau()) {
				membre(laClau(), elValor());
				return 1;
			} else {
				membre(o.elValor(), o.laClau());
				return -1;
			}
		default:
			if (elValor() < o.laClau()) {
				membre(laClau(), elValor());
				return -1; 
			} else {
				membre(o.elValor(), o.laClau());
				return 1;
			}
		}
	}
	@Override
	public void run() {
		try {
			Thread.sleep(elValor());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		super.run();
	}
	@Override
	public String toString() {
		return nom();
	}
}