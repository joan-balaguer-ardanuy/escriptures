package escriptures.temps;

public interface Regne<K> extends Abans<K> {
	K elSenyor();
	K elSenyor(K pare);
}