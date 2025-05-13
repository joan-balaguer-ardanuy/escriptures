package escriptures.temps;

import escriptures.Esperit;

public interface Vida<K,V>
	extends Regne<K>, Poder<V>, Esperit<K,V> {
	
	V posarFill(K pare, V fill);
	K posarPare(V fill, K pare);
	
	void recórrerPare(K pare, V fill);
	void recórrerFill(V fill, K pare);
	
	void concórrerPare(K pare, V fill);
	void concórrerFill(V fill, K pare);
	
	void permutarPare(K pare, V fill);
	void permutarFill(V fill, K pare);
	
	boolean permutarAntic(K pare, V fill);
	boolean permutarNou(V fill, K pare);
	
	boolean permutarAbans(K pare, V fill);
	boolean permutarDesprés(V fill, K pare);
	
	void permutarAntic();
	void permutarNou();
	
	void permutarAbans();	
	void permutarDesprés();
	
	Genital<K,V> membre();
	
	public interface Genital<K,V> extends Gènesi<K,V> {
		Vida<K,V> font();
		
    	void establirPare(K pare, V fill);
    	void establirFill(V fill, K pare);
	}
}