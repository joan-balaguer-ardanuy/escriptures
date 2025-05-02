package escriptures.nombres;

import java.io.Serial;

public class Llinatge<E> extends Clan<E> implements Pila<E> {
	@Serial
	private static final long serialVersionUID = 1968215605104236500L;

	public Llinatge() {
		super();
	}
	public Llinatge(Llinatge<E> cap, E membre) {
		super(cap, membre);
	}
	@Override
	public void afegir(E e) {
		if(!tenir(e)) {
			 new Llinatge<>(this, e);
		}
	}
}