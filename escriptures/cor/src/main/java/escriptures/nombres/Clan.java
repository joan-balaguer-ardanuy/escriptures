package escriptures.nombres;

import java.io.Serial;

public class Clan<E> extends Tribu<E> implements Conjunt<E> {

	@Serial
	private static final long serialVersionUID = -5454387310100535289L;
	
	public Clan() {
		super();
	}
	public Clan(Clan<E> cap, E membre) {
		super(cap, membre);
	}
	@Override
	public Conjunt<E> afegir(E e) {
		if(cercar(e) == null) {
			return new Clan<>(this, e);
		}
		else return null;
	}
}