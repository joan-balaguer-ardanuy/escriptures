package escriptures;

import java.io.Serial;

import escriptures.nombres.Enumerador;

public abstract class EsperitSant
	<K extends Esperit<K,V>,V extends Esperit<V,K>>
		extends Déu implements Esperit<K,V> {

	@Serial
	private static final long serialVersionUID = -7585603002394144901L;

	/**
	 * El pare.
	 */
	private K pare;
	
	/**
	 * El fill.
	 */
	private V fill;

	@Override
	public K pare() {
		return pare;
	}
	@Override
	public K pare(K pare) {
		K antic = this.pare;
		this.pare = pare;
		return antic;
	}
	@Override
	public V fill() {
		return fill;
	}
	@Override
	public V fill(V fill) {
		V nou = this.fill;
		this.fill = fill;
		return nou;
	}
	@Override
	public K passat() {
		return fill().fill();
	}
	@Override
	public K passat(K passat) {
		return fill().fill(passat);
	}
	@Override
	public V futur() {
		return fill().passat();
	}
	@Override
	public V futur(V futur) {
		return fill().passat(futur);
	}
	
	public EsperitSant() {
		super();
	}
	public EsperitSant(Gènere paritat) {
		super(paritat);
	}
	@SuppressWarnings("unchecked")
	public EsperitSant(Gènere paritat, V fill) {
		super(paritat);
		pare((K) this);
		fill(fill);
		fill.fill(pare());
		fill.pare(fill);
	}
	public EsperitSant(K pare) {
		super(pare.paritat());
		pare(pare);
		fill(pare.fill());
	}
	@SuppressWarnings("unchecked")
	public EsperitSant(K pare, V fill) {
		super(pare.paritat());
		pare(pare);
		fill(fill);
		pare.fill().fill((K) this);
		fill().fill().pare(pare.fill().fill());
		fill().fill().fill().pare(fill);
	}
	
	@Override
	public void rentar() {
		passat().pare(pare);
		futur().pare(pare.fill());
		passat(pare.passat(passat()));
		fill.pare(fill);
		pare(passat());
	}
	@Override
	public boolean ésBuit() {
		return pare() == this;
	}
	@Override
	public Enumerador<K> enumerador() {
		return null;
	}
}