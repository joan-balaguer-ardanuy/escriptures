package escriptures;

import java.io.Serial;

public abstract class Cel<K,V>
	extends Corona<Entrada<K,V>,Entrada<V,K>>
		implements Entrada<K,V> {
	@Serial
	private static final long serialVersionUID = -4207854470419806205L;

	K clau;
	V valor;
	
	@Override
	public K laClau() {
		return clau;
	}
	@Override
	public K laClau(K clau) {
		K antic = this.clau;
		this.clau = clau;
		return antic;
	}
	@Override
	public V elValor() {
		return valor;
	}
	@Override
	public V elValor(V valor) {
		V antic = this.valor;
		this.valor = valor;
		return antic;
	}
	
	public Cel() {
		super();
	}
	public Cel(Gènere paritat) {
		super(paritat);
	}
	public Cel(Class<? extends Entrada<V,K>> tipus, Gènere paritat, K clau, V valor) {
		super(tipus, paritat);
		laClau(clau);
		elValor(valor);
	}
	public Cel(Entrada<K,V> pare) {
		super(pare);
	}
	public Cel(Class<? extends Entrada<V,K>> tipus, Entrada<K,V> pare, K clau, V valor) {
		super(tipus, pare);
		laClau(clau);
		elValor(valor);
	}
	public Cel(Entrada<K,V> senyor, Gènere paritat) {
		super(senyor, paritat);
	}
	public Cel(Class<? extends Entrada<V,K>> tipus, Entrada<K,V> senyor, Gènere paritat, K clau, V valor) {
		super(tipus, senyor, paritat);
		laClau(clau);
		elValor(valor);
	}
	
	@Override
	public V obtenirValor(K clau) {
		for(Entrada<K,V> entrada : this) {
			if(entrada.laClau() == clau) {
				return entrada.elValor();
			}
		}
		return null;
	}
	@Override
	public K obtenirClau(V valor) {
		return elFill().obtenirValor(valor);
	}
	@Override
	public Entrada<K,V> obtenirPareSegonsClau(K clau) {
		for(Entrada<K,V> entrada : this) {
			if(entrada.laClau() == clau) {
				return entrada;
			}
		}
		return null;
	}
	@Override
	public Entrada<V,K> obtenirFillSegonsValor(V valor) {
		return elFill().obtenirPareSegonsClau(valor);
	}
	@Override
	public int índexDeClau(K clau) {
		int i = 0;
		for(Entrada<K,V> entrada : this) {
			i++;
			if(entrada.laClau() == clau) {
				return i;
			}
		}
		return -1;
	}
	@Override
	public int índexDeValor(V valor) {
		return elFill().índexDeClau(valor);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Entrada<K,V> establirValor(K clau, V valor) {
		return (Entrada<K,V>) crear(getClass(), elPare(), clau, valor);
	}
	@Override
	public Entrada<V,K> establirClau(V valor, K clau) {
		return elFill().establirValor(valor, clau);
	}
	@Override
	public V reemplaçarValor(K clau, V valor) {
		for(Entrada<K,V> entrada : this) {
			if(entrada.laClau() == clau) {
				return entrada.elValor(valor);
			}
		}
		return null;
	}
	@Override
	public K reemplaçarClau(V valor, K clau) {
		return elFill().reemplaçarValor(valor, clau);
	}
	@Override
	public boolean reemplaçarValor(K clau, V anticValor, V nouValor) {
		for(Entrada<K,V> entrada : this) {
			if(entrada.laClau() == clau ?
					entrada.elValor() == anticValor : false) {
				entrada.elValor(nouValor);
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean reemplaçarClau(V valor, K antigaClau, K novaClau) {
		return elFill().reemplaçarValor(valor, antigaClau, novaClau);
	}
	@Override
	public boolean tenirClau(K clau) {
		for(Entrada<K,V> entrada : this) {
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
	public V remoureValor(K clau) {
		for(Entrada<K,V> entrada : this) {
			if(entrada.laClau() == clau) {
				entrada.rentar();
				return entrada.elValor();
			}
		}
		return null;
	}
	@Override
	public K remoureClau(V valor) {
		for(Entrada<K,V> entrada : this) {
			if(entrada.elValor() == valor) {
				entrada.rentar();
				return entrada.laClau();
			}
		}
		return null;
	}
	@Override
	public boolean remoureValor(K clau, V valor) {
		for(Entrada<K,V> entrada : this) {
			if(entrada.laClau() == clau ?
					entrada.elValor() == valor : false) {
				entrada.rentar();
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean remoureClau(V valor, K clau) {
		return elFill().remoureValor(valor, clau);
	}
	
	/**
	 * El comparador empotrat entre les extensions.
	 */
	private transient Entrada.Comparador<K,V> comparador;
	
	@Override
	public Comparador<K,V> membre() {
		return comparador == null ? comparador = new Òrgan() : comparador;
	}
	@Override
	public Comparador<K,V> membre(K clau, V valor) {
		comparador = new Òrgan(valor, clau);
		return comparador;
	}
	
	/**
	 * L'òrgan reproductor.
	 */
	protected class Òrgan extends Reproductor
		implements Comparador<K,V> {
		
		protected Òrgan() {
			super();
		}
		@SuppressWarnings("unchecked")
		protected Òrgan(V clau, K valor) {
			super(crear(elFill().getClass(), clau, valor));
		}
		
		@Override
		public void establirPare(K clau, V valor) {
			// Ah, ah, ah...!
		}
		@Override
		public void establirFill(V clau, K valor) {
			// Ah, ah, ah...!
		}
	}
}