package escriptures.temps;

import escriptures.nombres.Enumerable;

public interface Antic<K> extends Enumerable<K> {

	K pare();
	K pare(K pare);

	boolean ésBuit();
	void rentar();
}