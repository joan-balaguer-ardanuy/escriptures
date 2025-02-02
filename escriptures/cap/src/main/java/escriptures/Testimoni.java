package escriptures;

import java.io.Serializable;

public interface Testimoni extends Serializable {
	
	/**
	 * @return
	 */
	String nom();
	
	/**
	 * @return
	 */
	int manament();
	void manament(int ordre);
	
	Gènere paritat();
	void paritat(Gènere paritat);

	void afegirTestimoni(Testimoni testimoni);
	void alliberarTestimoni(Testimoni testimoni);
	
	void testimoniatge(Testimoni font, Fet argument);
	
	/**
	 * @return
	 */
	Testimoni donarTestimoni();
}