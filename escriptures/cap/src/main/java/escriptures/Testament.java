package escriptures;

import java.io.Serial;
import java.util.Iterator;

import escriptures.nombres.Enumerador;

public abstract class Testament<E> 
	extends Sagrament<Nombre<E>> implements Nombre<E> {
	@Serial
	private static final long serialVersionUID = 2790235988548516839L;

	E membre;
	
	@Override
	public E element() {
		return membre;
	}
	@Override
	public E element(E membre) {
		E antic = this.membre;
		this.membre = membre;
		return antic;
	}
	
	protected Testament() {
		super();
	}
	protected Testament(E membre) {
		super();
		this.membre = membre;
	}
	protected Testament(Nombre<E> pare, E membre) {
		super(pare);
		this.membre = membre;
	}
	
	@Override
	public Nombre<E> rentar(E nombre) {
		return null;
	}
	@Override
	public boolean tenir(E membre) {
		Enumerador<E> en = enumerador();
		while (en.continuar()) {
			if(en.següent() == membre) {
				return true;
			}
		}
		return false;
	}
	@Override
	public Nombre<E> obtenir(E membre) {
		for (Nombre<E> n : this) {
			if(n.element() == membre) {
				return n;
			}
		}
		return null;
	}
	@Override
	public abstract Nombre<E> establir(E membre);
	
	public Enumerador<E> enumerador() {
		return new Reialme(iterator());
	}
	private final class Reialme implements Enumerador<E> {
		Iterator<Nombre<E>> iterador;
		
		Reialme(Iterator<Nombre<E>> a) {
			this.iterador = a;
		}
		@Override
		public boolean continuar() {
			return iterador.hasNext();
		}
		@Override
		public E següent() {
			return iterador.next().element();
		}
		@Override
		public void deslliurar() {
			iterador.remove();
		}
	}
}