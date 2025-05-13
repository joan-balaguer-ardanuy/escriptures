package escriptures;

import java.util.Random;

public enum Gènere {
	MASCLE,
	FEMELLA,
	HERMA;
	
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
	 * L'aleatorietat.
	 */
	private static Random alea = new Random();
	
	/**
	 * Retorna qualsevol gènere aleatòria.
	 * @return qualsevol gènere de manera aleatòria
	 */
	public static Gènere qualsevol() {
		if(alea.nextBoolean())
			return MASCLE;
		else return FEMELLA;
	}
}