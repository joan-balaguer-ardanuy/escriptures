package escriptures.temps;

public interface Nou<V> extends java.lang.Comparable<V>, java.util.concurrent.Executor {
	V elFill();
	V elFill(V fill);
}