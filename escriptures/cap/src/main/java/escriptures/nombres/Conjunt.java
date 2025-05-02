package escriptures.nombres;

import escriptures.Nombre;

public interface Conjunt<E> {	
	boolean buit();
	void rentar();
	
	boolean tenir(E element);
	void afegir(E element);
	void eliminar(E element);
	
	boolean tenirTot(Nombre<E> nombre);
	void afegirTot(Nombre<E> nombre);
	void eliminarTot(Nombre<E> nombre);
	void retenirTot(Nombre<E> nombre);
}