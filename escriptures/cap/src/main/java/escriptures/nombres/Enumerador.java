package escriptures.nombres;

import java.util.Iterator;

public interface Enumerador<E> extends Iterator<E> {
	E següent();
	boolean continuar();
	void deslliurar();
	
	@Override
	default boolean hasNext() {
		return continuar();
	}
	@Override
	default E next() {
		return següent();
	}
	@Override
	default void remove() {
		deslliurar();
	}
}