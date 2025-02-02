package escriptures.nombres;

import java.util.Iterator;

public interface Enumerador<E> extends Iterator<E> {
	E anterior();
	boolean continuar();
	void rentar();
	
	@Override
	default boolean hasNext() {
		return continuar();
	}
	@Override
	default E next() {
		return anterior();
	}
	@Override
	default void remove() {
		rentar();
	}
}