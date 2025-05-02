package escriptures.gènesi;

import escriptures.Entrada;
import escriptures.nombres.Conjunt;

public interface Vi<V,K> extends Entrada<V,K>, Conjunt<Entrada<V,K>> {
	K posar(V clau, K valor);
}