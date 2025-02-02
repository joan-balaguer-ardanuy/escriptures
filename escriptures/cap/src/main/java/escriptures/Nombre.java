package escriptures;

import java.io.Serializable;

import escriptures.temps.Antic;

public interface Nombre<E> 
	extends Antic<Nombre<E>>, Serializable {

	E element();
	E element(E element);

	Nombre<E> cercar(E element);
	Nombre<E> afegir(E element);
	
	boolean rentar(E element);
}