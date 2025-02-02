package escriptures.temps;

import escriptures.Esperit;

public interface Vida<K,V>
	extends Reialme<K>, Poder<V>, Esperit<K,V> {
	
	K Senyor();
	K Senyor(K pare);
	V Sobirana();
	V Sobirana(V fill);
	
	void afegirPare(K pare, V fill);
	void afegirFill(V fill, K pare);
	void sotmetrePare(K pare, V fill);
	void sotmetreFill(V fill, K pare);
	void permutarPare(K pare, V fill);
	
	V establirPare(K pare, V fill);
	K establirFill(V fill, K pare);
}