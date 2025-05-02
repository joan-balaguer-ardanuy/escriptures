package escriptures;

import java.io.Serial;
import java.util.Iterator;

import escriptures.temps.Regne;

public abstract class Sagrament<K extends Regne<K>>
	implements Regne<K> {
	@Serial
	private static final long serialVersionUID = 4862609690215175233L;
	
	K pare;
	K passat;
	K senyor;
	
	@Override
	public K elSenyor() {
		return senyor;
	}
	@Override
	public K elSenyor(K pare) {
		K senyor = this.senyor;
		this.senyor = pare;
		return senyor;
	}
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
	public K elPassat() {
		return passat;
	}
	@Override
	public K elPassat(K passat) {
		K remot = this.passat;
		this.passat = passat;
		return remot;
	}
	
	@SuppressWarnings("unchecked")
	protected Sagrament() {
		senyor = pare = passat = (K) this;
	}
	/**
	 * 
	 * <h3>Model de construcció recurrent</h3>
	 * <i>La instància pare esdevé la propietat Pare de la instància actual</i><br/>
	 * <br/>
	 * <tt>
	 * elPare(pare);<br/>
	 * elPassat(pare.elPassat());<br/>
	 * elPassat().elPare((K) this);<br/>
	 * pare.elPassat(elPassat().elPare());<br/>
	 * </tt>
	 * <h3>Model de construcció concurrent</h3>
	 * <i>La instància pare esdevé la propietat Passat de la instància actual</i><br/>
	 * <br/>
	 * <tt>
	 * elPare(pare.elPare());<br/>
	 * pare.elPare((K) this);<br/>
	 * elPassat(pare);<br/>
	 * elPare().elPassat(pare.elPare());<br/>
	 * </tt>
	 * <br/>
	 * @param pare
	 */
	@SuppressWarnings("unchecked")
	protected Sagrament(K pare) {
		elPare(pare);
		elPassat(pare.elPassat());
		elPassat().elPare((K) this);
		pare.elPassat(elPassat().elPare());
		elSenyor(pare.elSenyor());
	}

	@Override
	public boolean buit() {
		return elPare() == this;
	}
	@Override
	public void rentar() {
		// S'allibera únicament la instància pare. La propietat Pare de
		// la instància pare esdevé la propietat Pare de la instància actual.
		K antic = elPare(elPare().elPare());
		elPare().elPassat(antic.elPassat());
		antic.elPare(antic);
		antic.elPassat(antic);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<K> iterator() {
		return new Iterador<K>((K) this);
	}

	protected class Iterador<T extends Regne<T>> implements Iterator<T> {
		private T recurrent;
		private T anterior;
		private boolean continuar;
		
		Iterador(T pare) {
			anterior = recurrent = pare;
			continuar = true;
		}
		
		@Override
		public boolean hasNext() {
			return continuar;
		}
		@Override
		public T next() {
			recurrent = anterior;
			anterior = recurrent.elPare();
			if (recurrent == Sagrament.this) {
				continuar = false;
			} else continuar = true;
			return recurrent;
		}
		@Override
		public void remove() {
			recurrent.rentar();
			if (!recurrent.buit()) {
				anterior = recurrent.elPare();
			} else continuar = false;
		}
	}
}