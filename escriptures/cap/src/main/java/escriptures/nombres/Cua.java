package escriptures.nombres;

public interface Cua<E> extends Conjunt<E> {
	
	@Override
	void afegir(E element);
	
	E treure();
}