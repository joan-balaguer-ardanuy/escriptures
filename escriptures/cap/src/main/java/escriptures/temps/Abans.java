package escriptures.temps;

public interface Abans<K> extends Antic<K> {
	
	K passat();
	K passat(K passat);
}