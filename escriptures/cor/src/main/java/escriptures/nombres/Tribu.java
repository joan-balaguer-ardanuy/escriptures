package escriptures.nombres;

import java.io.Serial;

import escriptures.Nombre;
import escriptures.Testament;

public class Tribu<E> extends Testament<E> implements Nombre<E> {
	@Serial
	private static final long serialVersionUID = -6801327739465041215L;
	
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
	
	public Tribu() {
		super();
	}
	public Tribu(Nombre<E> cap, E membre) {
		super(cap);
		this.membre = membre;
	}
	
	@Override
	public Nombre<E> afegir(E membre) {
		if(cercar(membre) == null) {
			return new Tribu<>(this, membre);
		}
		else return null;
	}
}