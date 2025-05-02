package escriptures;

import java.io.Serial;
import java.util.Iterator;

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
	public K elPare() {
		return pare;
	}
	@Override
	public K elPare(K pare) {
		K antic = this.pare;
		this.pare = pare;
		return antic;
	}
	@Override
	public V elFill() {
		return fill;
	}
	@Override
	public V elFill(V fill) {
		V nou = this.fill;
		this.fill = fill;
		return nou;
	}
	@Override
	public K elPassat() {
		return elFill().elFill();
	}
	@Override
	public K elPassat(K passat) {
		return elFill().elFill(passat);
	}
	@Override
	public V elFutur() {
		return elFill().elPassat();
	}
	@Override
	public V elFutur(V futur) {
		return elFill().elPassat(futur);
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
		elPare((K) this);
		elFill(fill);
		fill.elFill(elPare());
		fill.elPare(fill);
	}
	public EsperitSant(K pare) {
		super(pare.paritat());
		elPare(pare);
		elFill(pare.elFill());
	}
	@SuppressWarnings("unchecked")
	public EsperitSant(K pare, V fill) {
		super(pare.paritat());
		elPare(pare);
		elFill(fill);
		pare.elPassat((K) this);
		elPassat().elPare(pare.elPassat());
		elFutur().elPare(fill);
	}
	
	@Override
	public void rentar() {
		elPassat().elPare(elPare());
		elFutur().elPare(elPare().elFill());
		elPassat(elPare().elPassat(elPassat()));
		elFill().elPare(elFill());
		elPare(elPassat());
	}
	@Override
	public boolean buit() {
		return elPare() == this;
	}
	@Override
	public boolean tenirPare(K pare) {
		for(K recurrent : this) {
			if(recurrent == pare) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean tenirFill(V fill) {
		return elFill().tenirPare(fill);
	}
	@Override
	public Iterator<K> iterator() {
		return new Iterador(pare);
	}
	
	protected final class Iterador implements java.util.Iterator<K> {
		private K recurrent;
		private K pare;
		private boolean seguir;
		
		Iterador(K pare) {
			pare = recurrent = pare;
			seguir = true;
		}
		@Override
		public boolean hasNext() {
			return seguir;
		}
		@Override
		public K next() {
			recurrent = pare;
			pare = recurrent.elPare();
			if (recurrent == EsperitSant.this) {
				seguir = false;
			} else seguir = true;
			return recurrent;
		}
		@Override
		public void remove() {
			recurrent.rentar();
			if (!recurrent.buit()) {
				pare = recurrent.elPare();
			} else seguir = false;
		}
	}
	@Override
	public abstract Gènesi<K,V> membre();
	
	@Override
	public void execute(Runnable command) {
		// Ah, ah, ah...!	
	}
}