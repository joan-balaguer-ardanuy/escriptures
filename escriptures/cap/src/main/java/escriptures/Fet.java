package escriptures;

import java.io.Serial;

public class Fet implements Testimoni {
	@Serial
	private static final long serialVersionUID = 7515334054137685548L;
	
	Testimoni font;

	public Testimoni font() {
		return font;
	}
	@Override
	public String nom() {
		return font.nom();
	}
	@Override
	public int manament() {
		return font.manament();
	}
	@Override
	public void manament(int ordre) {
		font.manament(ordre);
	}
	@Override
	public Gènere paritat() {
		return font.paritat();
	}
	@Override
	public void paritat(Gènere paritat) {
		font.paritat(paritat);
	}
	
	public Fet(Testimoni font) {
		this.font = font;
	}

	@Override
	public Testimoni declarar() {
		return font().declarar();
	}
	@Override
	public void afegirTestimoni(Testimoni testimoni) {
		font().afegirTestimoni(testimoni);
	}
	@Override
	public void testimoniatge(Testimoni font, Fet argument) {
		font().testimoniatge(font, argument);
	}
	@Override
	public void run() {
		font().run();
	}
}