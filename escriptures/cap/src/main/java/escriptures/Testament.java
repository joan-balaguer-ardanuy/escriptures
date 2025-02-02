package escriptures;

import java.io.Serial;

import escriptures.nombres.Enumerador;

public abstract class Testament<T>
	implements Nombre<T> {

	@Serial
	private static final long serialVersionUID = 4862609690215175233L;
	
	Nombre<T> antic;
	
	@Override
	public Nombre<T> pare() {
		return antic;
	}
	@Override
	public Nombre<T> pare(Nombre<T> pare) {
		Nombre<T> antic = this.antic;
		this.antic = pare;
		return antic;
	}
	
	protected Testament() {
		antic = this;
	}
	protected Testament(Nombre<T> antic) {
		pare(antic.pare());
		antic.pare(this);
	}

	@Override
	public Enumerador<Nombre<T>> enumerador() {
		return new Anterioritat(pare());
	}
	@Override
	public boolean ésBuit() {
		return pare() == this;
	}
	@Override
	public void rentar() {
		pare().pare(pare(pare().pare()));
	}
	@Override
	public boolean rentar(T element) {
		Enumerador<Nombre<T>> declaracions = enumerador();
		while(declaracions.continuar()) {
			if(declaracions.anterior().element().equals(element)) {
				declaracions.rentar();
				return true;
			}
		}
		return false;
	}
	@Override
	public Nombre<T> cercar(T element) {
		Enumerador<Nombre<T>> declaracions = enumerador();
		while(declaracions.continuar()) {
			Nombre<T> n = declaracions.anterior();
			if(n.element().equals(element)) {
				return n;
			}
		}
		return null;
	}
	
	private final class Anterioritat implements Enumerador<Nombre<T>> {
		private Nombre<T> testament;
		private Nombre<T> antic;
		private boolean continuar;
		
		Anterioritat(Nombre<T> pare) {
			this.antic = testament = pare;
			continuar = true;
		}
		@Override
		public boolean continuar() {
			return continuar;
		}
		@Override
		public Nombre<T> anterior() {
			testament = antic;
			antic = testament.pare();
			if (testament == Testament.this) {
				continuar = false;
			} else continuar = true;
			return testament;
		}
		@Override
		public void rentar() {
			testament.rentar();
			if (!testament.ésBuit()) {
				antic = testament.pare();
			} else continuar = false;
		}
	}
}