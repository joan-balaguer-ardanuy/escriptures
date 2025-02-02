package escriptures;

import java.util.Random;

public enum Gènere {
	MASCLE,
	FEMELLA,
	HERMA;
	
	/**
	 * L'aleatorietat.
	 */
	private static Random alea = new Random();
	
	/**
	 * Retorna el gènere oposat a aquest.
	 * @return el gènere oposat a aquest
	 */
	public Gènere oposat() {
		if(this == Gènere.FEMELLA)
			return MASCLE;
		else if(this == Gènere.MASCLE)
			return FEMELLA;
		else return HERMA;
	}
	
	/**
	 * Retorna qualsevol gènere aleatòria.
	 * @return qualsevol gènere de manera aleatòria
	 */
	public static Gènere qualsevol() {
		switch (alea.nextInt(3)) {
		case 0:
			return MASCLE;
		case 1:
			return FEMELLA;
		default:
			return HERMA;
		}
	}
}