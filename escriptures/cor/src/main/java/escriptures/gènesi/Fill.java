package escriptures.gènesi;

import java.io.Serial;

import escriptures.Cel;
import escriptures.Entrada;
import escriptures.Gènere;
import escriptures.Nombre;
import escriptures.nombres.Enumerador;

public abstract class Fill<V,K>
	extends Cel<V,K> implements Vi<V,K> {
	@Serial
	private static final long serialVersionUID = -166706759903829661L;
	
	public Fill() {
		super();
	}
	public Fill(Gènere paritat) {
		super(paritat);
	}
	public Fill(Class<? extends Entrada<K,V>> tipus, Gènere paritat, V clau, K valor) {
		super(tipus, paritat, clau, valor);
	}
	public Fill(Entrada<V,K> pare) {
		super(pare);
	}
	public Fill(Class<? extends Entrada<K,V>> tipus, Entrada<V,K> pare, V clau, K valor) {
		super(tipus, pare, clau, valor);
	}
	public Fill(Entrada<V,K> sobirana, Gènere paritat) {
		super(sobirana, paritat);
	}
	public Fill(Class<? extends Entrada<K,V>> tipus, Entrada<V,K> sobirana, Gènere paritat, V clau, K valor) {
		super(tipus, sobirana, paritat, clau, valor);
	}

	@Override
	public boolean tenir(Entrada<V,K> anyell) {
        return tenirPare(anyell);
	}
	@Override
	public K posar(V clau, K valor) {
		Entrada<V,K> e;
		if((e = obtenirPareSegonsClau(clau)) != null) {
			return e.elValor(valor);
		} else {
			establirValor(clau, valor);
			return null;
		}
	}
	@Override
	public void afegir(Entrada<V,K> anyell) {
		afegirPare(anyell, anyell.elFill());
	}
	@Override
	public void eliminar(Entrada<V,K> anyell) {
		if(tenir(anyell)) {
			anyell.rentar();
		}
	}
	@Override
	public boolean tenirTot(Nombre<Entrada<V,K>> nombre) {
		Enumerador<Entrada<V,K>> en = nombre.enumerador();
		while(en.continuar()) {
			if(!tenir(en.següent())) {
				return false;
			}
		}
		return true;
	}
	@Override
	public void afegirTot(Nombre<Entrada<V,K>> nombre) {
		Enumerador<Entrada<V,K>> en = nombre.enumerador();
		while(en.continuar()) {
			afegir(en.següent());
		}
	}
	@Override
	public void retenirTot(Nombre<Entrada<V,K>> nombre) {
		for(Entrada<V,K> e : this) {
			if(!nombre.tenir(e)) {
				e.rentar();
			}
		}
	}
	@Override
	public void eliminarTot(Nombre<Entrada<V,K>> nombre) {
		for(Entrada<V,K> e : this) {
			if(nombre.tenir(e)) {
				e.rentar();
			}
		}
	}
}