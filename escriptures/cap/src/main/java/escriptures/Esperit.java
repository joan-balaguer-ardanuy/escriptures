package escriptures;

import escriptures.temps.Després;
import escriptures.temps.Abans;

public interface Esperit<K,V> 
	extends Abans<K>, Després<V>, Testimoni {
	
}