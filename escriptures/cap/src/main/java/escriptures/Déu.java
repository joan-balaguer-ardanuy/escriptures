package escriptures;

import java.io.Serial;

public abstract class Déu implements Testimoni {
	@Serial
	private static final long serialVersionUID = 1082537671732028590L;
	
	private int ordre;
	private Gènere paritat;
	private Nombre<Testimoni> testimonis;

	@Override
	public abstract String nom();

	@Override
	public int manament() {
		return ordre;
	}
	@Override
	public void manament(int ordre) {
		this.ordre = ordre;
	}
	@Override
	public Gènere paritat() {
		return paritat;
	}
	@Override
	public void paritat(Gènere paritat) {
		this.paritat = paritat;
	}

	public Déu() {
		this.ordre = Precepte.GÈNESI;
		this.paritat = Gènere.HERMA;
	}
	public Déu(Gènere paritat) {
		this.ordre = Precepte.GÈNESI;
		this.paritat = paritat;
	}

	@Override
	public void afegirTestimoni(Testimoni testimoni) {
		if(testimonis == null) {
			testimonis = new Tribunal(testimoni);
		}
		testimonis.establir(testimoni);
	}
	@Override
	public Testimoni declarar() {
		try {
			Testimoni testimoni = getClass().getConstructor().newInstance();
			testimoni.paritat(paritat);
			return testimoni;
		} catch (Throwable t) {
			throw new Error("Déu: excepció en la declaració.", t);
		}
	}
	protected void donarTestimoni(Fet e) {
		if(testimonis != null) {
			for(Nombre<Testimoni> testimoni : testimonis) {
			 	testimoni.element().testimoniatge(this, e);
			}
		}
	}
	@Override
	public void testimoniatge(Testimoni font, Fet argument) {
		donarTestimoni(argument);
	}

	public class Tribunal extends Testament<Testimoni> {
		@Serial
		private static final long serialVersionUID = -263086116387761309L;
		
		protected Tribunal(Testimoni testimoni) {
			super(testimoni);
		}
		protected Tribunal(Nombre<Testimoni> jutge, Testimoni testimoni) {
			super(jutge, testimoni);
		}
		@Override
		public Nombre<Testimoni> establir(Testimoni testimoni) {
			return new Tribunal(testimonis, testimoni);
		}
	}
	
	/**
	 * Crea nova instància d'objecte de <tt>java.lang.Class&lt;X&gt;</tt>.
	 * @param <X> el tipus de l'objecte retornat
	 * @param classe la {@link Class} de l'objecte.
	 * @param arguments els objectes durant la construcció de la instància
	 * @return la nova instància&lt;X&gt;
	 */
	protected static final <X> X crear(Class<X> classe, Object... arguments) {
		try {
			return classe.getDeclaredConstructor(obtenirClasses(arguments)).newInstance(arguments);
		}
		catch(Throwable t) {
			throw new Error(t);
		}
	}
	/**
	 * Mètode auxiliar invocat durant l'execució del mètdoe {@link #crear(Class classe, Object... arguments)
	 *  crear(Class classe, Object... arguments)} de creació, configura nou java.lang.Array de java.lang.Class 
	 * concretes segons els arguments d'entrada. Per cada objecte entrant se'n estableix l'objecte relatiu a
	 * la seva classe.
	 * <ul>
	 * <li>Objecte d'entrada: java.lang.Object[] { objecte, cosa, cos, ... }</li>
	 * <li>Objecte de sortida: java.lang.Class[] { Classe&lt;Objecte&gt;, Classe&lt;Cosa&gt;, Classe&lt;Cos&gt;, ... }</li>
	 * </ul>
	 * @param arguments java.lang.Object[] els objectes d'entrada
	 * @return java.lang.Class<?>[] les classes de sortida
	 */
	private static final Class<?>[] obtenirClasses(Object... arguments) {
		Class<?>[] classes = new Class<?>[arguments.length];
		for(int i = 0; i < arguments.length; i++) {
			classes[i] = arguments[i].getClass();
		}
		return classes;
	}
}