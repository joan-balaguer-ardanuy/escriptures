package escriptures.gènesi;

import escriptures.Entrada;
import escriptures.Gènere;

import java.io.Serial;

import escriptures.Cel;

public abstract class Pare<K,V>
	extends Cel<K,V> implements Sang<K,V> {
	@Serial
	private static final long serialVersionUID = -5317124137270573090L;
	
	public Pare() {
		super();
	}
	public Pare(Gènere paritat) {
		super(paritat);
	}
	public Pare(Class<? extends Entrada<V,K>> tipus, Gènere paritat, K clau, V valor) {
		super(tipus, paritat, clau, valor);
	}
	public Pare(Entrada<K,V> pare) {
		super(pare);
	}
	public Pare(Class<? extends Entrada<V,K>> tipus, Entrada<K, V> pare, K clau, V valor) {
		super(tipus, pare, clau, valor);
	}
	public Pare(Entrada<K,V> senyor, Gènere paritat) {
		super(senyor, paritat);
	}
	public Pare(Class<? extends Entrada<V,K>> tipus, Entrada<K,V> senyor, Gènere paritat, K clau, V valor) {
		super(tipus, senyor, paritat, clau, valor);
	}

	@Override
	public boolean tenirClau(K clau) {
		for(Entrada<K,V> entrada : entrada()) {
			if(entrada.laClau() == clau) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean tenirValor(V valor) {
		return elFill().tenirClau(valor);
	}
	@Override
	public V posar(K clau, V valor) {
		for(Entrada<K,V> entrada : entrada()) {
			if(entrada.laClau() == clau) {
				return entrada.elValor(valor);
			}
		}
		crear(getClass(), elPare(), clau, valor);
		return null;
	}
	@Override
	public V cercarValor(K clau) {
		for(Entrada<K,V> entrada : entrada()) {
			if(entrada.laClau() == clau) {
				return entrada.elValor();
			}
		}
		return null;
	}
	@Override
	public K cercarClau(V valor) {
		for(Entrada<K,V> entrada : entrada()) {
			if(entrada.elValor() == valor) {
				return entrada.laClau();
			}
		}
		return null;
	}
	@Override
	public Entrada<K,V> entrada() {
		return this;
	}
}