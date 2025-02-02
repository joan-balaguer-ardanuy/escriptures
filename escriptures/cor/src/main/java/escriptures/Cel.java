package escriptures;

import java.io.Serial;

public abstract class Cel<K,V>
	extends Corona<Anyell<K,V>,Anyell<V,K>>
		implements Anyell<K,V> {

	@Serial
	private static final long serialVersionUID = -4207854470419806205L;

}