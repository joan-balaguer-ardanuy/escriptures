package escriptures;

import java.io.Serial;

import escriptures.nombres.Enumerador;
import escriptures.temps.Vida;

public abstract class Corona
	<K extends Vida<K,V>,V extends Vida<V,K>> 
		extends EsperitSant<K,V> implements Vida<K,V> {

	@Serial
	private static final long serialVersionUID = -9068705454641458380L;

	/**
	 * El Pare.
	 */
	private K pare;
	
	/**
	 * El Fill.
	 */
	private V fill;
	
	@Override
	public K Senyor() {
		return pare;
	}
	@Override
	public K Senyor(K pare) {
		K antic = this.pare;
		this.pare = pare;
		return antic;
	}
	@Override
	public V Sobirana() {
		return fill;
	}
	@Override
	public V Sobirana(V fill) {
		V nou = this.fill;
		this.fill = fill;
		return nou;
	}
	
	public Corona() {
		super();
	}
	public Corona(Gènere paritat) {
		super(paritat);
	}
	public Corona(Class<? extends V> tipus, Gènere paritat) {
		super(paritat, crear(tipus, paritat.oposat()));
		Senyor(pare());
		Sobirana(fill());
	}
	public Corona(K pare) {
		super(pare);
		Senyor(pare.Senyor());
	}
	public Corona(Class<? extends V> tipus, K pare) {
		super(pare, crear(tipus, pare.fill()));
		Senyor(pare.Senyor());
	}
	public Corona(K déu, Gènere paritat) {
		super(paritat);
		Senyor(déu);
	}
	public Corona(Class<? extends V> tipus, K déu, Gènere paritat) {
		super(paritat, crear(tipus, déu.Sobirana(), paritat.oposat()));
		Senyor(déu);
	}

	@Override
	public boolean alliberaPare(K pare) {
		Enumerador<K> it = enumerador();
		while(it.continuar()) {
			if(it.anterior().equals(pare)) {
				it.rentar();
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean afegirPare(K pare) {
		return false;
	}
	@Override
	public boolean téPare(K pare) {
		Enumerador<K> it = enumerador();
		while(it.continuar())  {
			if(it.anterior().equals(pare)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean redimirFill(V fill) {
		return false;
	}
	@Override
	public boolean sotmetreFill(V fill) {
		return false;
	}
	@Override
	public boolean contéFill(V fill) {
		return false;
	}
	@Override
	public void afegirPare(K pare, V fill) {
		pare.pare(pare());
		fill.pare(fill().pare());
		fill.fill(pare().passat());
		pare().passat(pare);
		pare(pare);
		fill().pare(fill);
	}
	@Override
	public void afegirFill(V fill, K pare) {
		
	}
	@Override
	public void sotmetrePare(K pare, V fill) {
		
	}
	@Override
	public void sotmetreFill(V fill, K pare) {
		fill.afegirPare(fill, pare);
	}
	@Override
	public void permutarPare(K pare, V fill) {
		
	}
	@Override
	public V establirPare(K pare, V fill) {
		return null;
	}
	@Override
	public K establirFill(V fill, K pare) {
		return null;
	}
}