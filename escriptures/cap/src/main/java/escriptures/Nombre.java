package escriptures;

import escriptures.nombres.Element;
import escriptures.nombres.Enumerable;
import escriptures.temps.Regne;

public interface Nombre<N> 
	extends Regne<Nombre<N>>, Element<N>, Enumerable<N> {

	Nombre<N> obtenir(N membre);
	Nombre<N> establir(N membre);
	Nombre<N> rentar(N membre);
	boolean tenir(N membre);
}