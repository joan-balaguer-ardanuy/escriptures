package escriptures;

import escriptures.temps.Després;
import escriptures.temps.Abans;

public interface Esperit<K,V> 
	extends Abans<K>, Després<V>, Testimoni {
	
	K elPare();
	K elPare(K pare);
	V elFill();
	V elFill(V fill);
	
	boolean buit();
	void rentar();
	
	boolean tenirPare(K pare);
	boolean tenirFill(V fill);
	
	Gènesi<K,V> membre();
	
	public interface Gènesi<K,V> {
		int procrear(K pare, V fill);
	}
}