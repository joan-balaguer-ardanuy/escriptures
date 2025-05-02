package escriptures.nombres;

import escriptures.Entrada;

public interface Diccionari<K,V> {

	Entrada<K,V> entrada();
	
	V posar(K clau, V valor);
	
	boolean buit();
	boolean tenirClau(K clau);
	boolean tenirValor(V valor);
	V cercarValor(K clau);
	K cercarClau(V valor);
}