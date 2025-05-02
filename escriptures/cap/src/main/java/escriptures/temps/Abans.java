package escriptures.temps;

public interface Abans<K> extends Antic<K> {
	K elPassat();
	K elPassat(K passat);
	
	void rentar();
	boolean buit();
}