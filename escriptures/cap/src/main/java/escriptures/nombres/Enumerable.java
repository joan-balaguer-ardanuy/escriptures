package escriptures.nombres;

import java.util.Iterator;

public interface Enumerable<E> extends Iterable<E> {
	
	Enumerador<E> enumerador();

	default Iterator<E> iterator() {
		return enumerador();
	}
}