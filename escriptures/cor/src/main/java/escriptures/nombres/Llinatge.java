package escriptures.nombres;

import java.io.Serial;

public class Llinatge<E> extends Clan<E> implements Cua<E> {

	@Serial
	private static final long serialVersionUID = 1968215605104236500L;

	public Llinatge() {
		super();
	}
	public Llinatge(Llinatge<E> cap, E membre) {
		super(cap, membre);
	}
	@Override
	public Cua<E> afegir(E e) {
		if(cercar(e) == null) {
			return new Llinatge<>(this, e);
		}
		else return null;
	}
}