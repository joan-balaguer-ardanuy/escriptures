package escriptures.temps;

import escriptures.Esperit;

public interface Vida<K,V>
	extends Regne<K>, Poder<V>, Esperit<K,V> {
	
	V posarPare(K pare, V fill);
	K posarFill(V fill, K pare);
	
	void afegirPare(K pare, V fill);
	void afegirFill(V fill, K pare);
	
	void sotmetrePare(K pare, V fill);
	void sotmetreFill(V fill, K pare);
	
	void permutarPare(K pare, V fill);
	void permutarFill(V fill, K pare);
	
	Genital<K,V> membre();
	
	public interface Genital<K,V> extends Gènesi<K,V> {
		Vida<V,K> font();
	}
}