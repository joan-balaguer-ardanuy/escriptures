package escriptures.temps;

import java.io.Serializable;

public interface Antic<K> extends Iterable<K>, Serializable {
	K elPare();
	K elPare(K pare);
}