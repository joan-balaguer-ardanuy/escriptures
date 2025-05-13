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
	public void recórrerPare(K pare, V fill) {
		pare.elPare(elPare());
		fill.elPare(elFill().elPare());
		fill.elFill(elPare().elPassat());
		elPare().elPassat(pare);
		elPare(pare);
		elFill().elPare(fill);
	}
	@Override
	public void recórrerFill(V fill, K pare) {
		fill.recórrerPare(fill, pare);
	}
	@Override
	public void concórrerPare(K pare, V fill) {
		elPassat().elPare(pare);
		elFutur().elPare(fill);
		fill.elFill(elPassat());
		pare.elPare(elPare().elPassat());
		fill.elPare(elFill());
		elPassat(pare);
	}
	@Override
	public void concórrerFill(V fill, K pare) {
		fill.recórrerPare(fill, pare);
	}
	@Override
	public V posarFill(K pare, V fill) {
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
	public K posarPare(V fill, K pare) {
		return elFill().posarFill(fill, pare);
	}
	
	public boolean permutarAntic(K pare, V fill) {
		if(pare == elPare() && fill == elPare().elFill()) {
			elPassat().elPare(pare);
			elFutur().elPare(fill);
			elPare(pare.elPare());
			elFill().elPare(fill.elPare());
			elPare().elPassat(fill.elFill(elPassat()));
			elPassat(pare);
			pare.elPare(elPare().elPassat());
			fill.elPare(elFill());
			return true;
		}
		return false;
	}
	@Override
	public boolean permutarNou(V fill, K pare) {
		return elFill().permutarAntic(fill, pare);
	}
	public boolean permutarAbans(K pare, V fill) {
		if(pare == elPassat() && fill == elFutur()) {
			pare.elPare(elPare());
			fill.elPare(elFill().elPare());
			elPassat(fill.elFill());
			elPassat().elPare(elPare().elPassat(pare));
			elFutur().elPare(elFill());
			fill.elFill(elPare().elPassat());
			elPare(pare);
			elFill().elPare(fill);
			return true;
		}
		return false;
	}
	@Override
	public boolean permutarDesprés(V fill, K pare) {
		return elFill().permutarAbans(fill, pare);
	}
	@Override
	public void permutarPare(K pare, V fill) {
		if(permutarAntic(pare, fill)) {
			return;
		} else if(permutarAbans(pare, fill)) {
			return;
		} else {
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
	public void permutarAntic() {
		permutarAntic(elPare(), elPare().elFill());
	}
	@Override
	public void permutarNou() {
		elFill().permutarAntic();
	}
	@Override
	public void permutarAbans() {
		permutarAbans(elPassat(), elFutur());
	}
	@Override
	public void permutarDesprés() {
		elFill().permutarAbans();
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
		Vida<K,V> font;
		
		@Override
		public Vida<K,V> font() {
			return font;
		}
		
		protected Reproductor() {
			this.font = null;
		}
		protected Reproductor(Vida<K,V> font) {
			this.font = font;
		}
		
		@Override
		public int procrear(K pare, V fill) {
			// Ah, ah, ah...!
			return 0;
		}
		@Override
		public void establirPare(K pare, V fill) {
			// Ah, ah, ah...!
		}
		@Override
		public void establirFill(V fill, K pare) {
			// Ah, ah, ah...!
		}
	}
}