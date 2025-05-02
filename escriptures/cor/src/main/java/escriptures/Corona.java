package escriptures;

import java.io.Serial;

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
	public K elSenyor() {
		return pare;
	}
	@Override
	public K elSenyor(K pare) {
		K antic = this.pare;
		this.pare = pare;
		return antic;
	}
	@Override
	public V laSobirana() {
		return fill;
	}
	@Override
	public V laSobirana(V fill) {
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
		elSenyor(elPare());
		laSobirana(elFill());
	}
	public Corona(K pare) {
		super(pare);
		elSenyor(pare.elSenyor());
	}
	public Corona(Class<? extends V> tipus, K pare) {
		super(pare, crear(tipus, pare.elFill()));
		elSenyor(pare.elSenyor());
	}
	public Corona(K déu, Gènere paritat) {
		super(paritat);
		elSenyor(déu);
	}
	public Corona(Class<? extends V> tipus, K déu, Gènere paritat) {
		super(paritat, crear(tipus, déu.laSobirana(), paritat.oposat()));
		elSenyor(déu);
	}

	@Override
	public void afegirPare(K pare, V fill) {
		pare.elPare(elPare());
		fill.elPare(elFill().elPare());
		fill.elFill(elPare().elPassat());
		elPare().elPassat(pare);
		elPare(pare);
		elFill().elPare(fill);
	}
	@Override
	public void afegirFill(V fill, K pare) {
		fill.afegirPare(fill, pare);
	}
	@Override
	public void sotmetrePare(K pare, V fill) {
		elPassat().elPare(pare);
		elFutur().elPare(fill);
		fill.elFill(elPassat());
		pare.elPare(elPare().elPassat());
		fill.elPare(elFill());
		elPassat(pare);
	}
	@Override
	public void sotmetreFill(V fill, K pare) {
		fill.afegirPare(fill, pare);
	}
	@Override
	public void permutarPare(K pare, V fill) {
		if(pare == elPare()) {
			elPassat().elPare(pare);
			elFutur().elPare(fill);
			elPare(pare.elPare());
			elFill().elPare(fill.elPare());
			elPare().elPassat(fill.elFill(elPassat()));
			elPassat(pare);
			pare.elPare(elPare().elPassat());
			fill.elPare(elFill());
		}
		else if(pare == elPassat()) {
			pare.elPare(elPare());
			fill.elPare(elFill().elPare());
			elPassat(fill.elFill());
			elPassat().elPare(elPare().elPassat(pare));
			elFutur().elPare(elFill());
			fill.elFill(elPare().elPassat());
			elPare(pare);
			elFill().elPare(fill);
		}
		else {
			V valor = fill.elPare(elFill().elPare());
			K clau = fill.elFill(elPassat());
			valor.elFill(elPare().elPassat());
			elPare().elPassat(pare);
			elPare(pare.elPare(elPare()));
			elFill().elPare(valor);
			elPassat().elPare(pare);
			elFutur().elPare(fill);
			elPassat(clau);
			elPassat().elPare(elPare().elPassat());
			elFutur().elPare(elFill());
		}
	}
	@Override
	public void permutarFill(V fill, K pare) {
		elFill().permutarPare(fill, pare);
	}
	@Override
	public V posarPare(K pare, V fill) {
		for(K recurrent : this)  {
			if(recurrent == pare) {
				fill.elPare(pare.elPare().elFill());
				pare.elFutur().elPare(fill);
				fill.elFill(pare.elPassat());
				return pare.elFill(fill);
			}
		}
		return null;
	}
	@Override
	public K posarFill(V fill, K pare) {
		return elFill().posarPare(fill, pare);
	}
	
	@Override
	public abstract Genital<K,V> membre();

	/**
	 * 
	 */
	protected class Reproductor implements Genital<K,V> {
		
		/**
		 * La sortida
		 */
		Vida<V,K> font;
		
		@Override
		public Vida<V,K> font() {
			return font;
		}
		
		protected Reproductor() {
			this.font = null;
		}
		protected Reproductor(Vida<V,K> font) {
			this.font = font;
		}
		
		@Override
		public int reproduir(K pare, V mare) {
			// Ah, ah, ah...!
			return 0;
		}
	}
}