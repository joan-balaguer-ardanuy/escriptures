package escriptures.temps;

public interface Reialme<K> extends Abans<K> {
	
	boolean alliberaPare(K pare);
	boolean afegirPare(K pare);
	boolean téPare(K pare);
}