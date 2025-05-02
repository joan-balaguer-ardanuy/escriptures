package escriptures.nombres;

public interface Pila<E> extends Cua<E> {

	@Override
	void afegir(E element);
	
	E treure();
}