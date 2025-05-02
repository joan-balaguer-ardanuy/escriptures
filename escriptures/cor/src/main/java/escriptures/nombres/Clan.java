package escriptures.nombres;

import java.io.Serial;

import escriptures.Nombre;

public class Clan<E> 
	extends Tribu<E> implements Cua<E> {
	@Serial
	private static final long serialVersionUID = -5454387310100535289L;
	
	public Clan() {
		super();
	}
	public Clan(E membre) {
		super(membre);
	}
	public Clan(Nombre<E> cap, E membre) {
		super(cap, membre);
	}
	@Override
	public E treure() {
		return null;
	}
	@Override
	public void afegir(E membre) {
		if(!tenir(membre)) {
			new Clan<>(this, membre);
		}
	}
}