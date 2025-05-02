package escriptures;

import java.io.Serializable;

/**
 * <h3>Testimoni de Déu</h3>
 * <h3>Espai de noms: escriptures</h3>
 */
public interface Testimoni extends Runnable, Serializable {
	
	String nom();
	int manament();
	void manament(int ordre);
	Gènere paritat();
	void paritat(Gènere paritat);
	
	void afegirTestimoni(Testimoni testimoni);
	void testimoniatge(Testimoni font, Fet argument);
	
	/**
	 * @return
	 */
	Testimoni declarar();
}