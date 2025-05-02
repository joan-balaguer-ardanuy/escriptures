package escriptures.nombres;

import java.io.Serial;

import escriptures.Nombre;
import escriptures.Testament;

public class Tribu<E>
	extends Testament<E> implements Conjunt<E> {
	@Serial
	private static final long serialVersionUID = 4862609690215175233L;
	
	public Tribu() {
		super();
	}
	public Tribu(E membre) {
		super(membre);
	}
	public Tribu(Nombre<E> antic, E membre) {
		super(antic, membre);
	}

	@Override
	public Nombre<E> establir(E membre) {
		if(!tenir(membre))
			return new Tribu<E>(this, membre);
		else return null;
	}
	@Override
	public void afegir(E membre) {
		establir(membre);
	}
	@Override
	public boolean tenir(E membre) {
		Enumerador<E> en = enumerador();
		while(en.continuar()) {
			if(en.següent() == membre) {
				return true;
			}
		}
		return false;
	}
	@Override
	public void eliminar(E membre) {
		rentar(membre);
	}
	@Override
	public void afegirTot(Nombre<E> nombre) {
		Enumerador<E> en = nombre.enumerador();
		while(en.continuar()) {
			afegir(en.següent());
		}
	}
	@Override
	public boolean tenirTot(Nombre<E> nombre) {
		Enumerador<E> en = nombre.enumerador();
		boolean resultat = true;
		while(en.continuar()) {
			if(!tenir(en.següent())) {
				resultat = false;				
			}
		}
		return resultat;
	}
	@Override
	public void retenirTot(Nombre<E> nombre) {
		Enumerador<E> en = enumerador();
		while(en.continuar()) {
			if(!nombre.tenir(en.següent())) {
				
			}
		}
	}
	@Override
	public void eliminarTot(Nombre<E> nombre) {
		Enumerador<E> en = nombre.enumerador();
		if(en.continuar() ) {
			Nombre<E> n;
			if((n = obtenir(en.següent())) != null) {
				n.rentar();
			}
		}
	}
}