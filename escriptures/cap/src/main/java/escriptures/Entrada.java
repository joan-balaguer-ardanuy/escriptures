package escriptures;

import escriptures.temps.Vida;

public interface Entrada<K,V>
	extends Vida<Entrada<K,V>,Entrada<V,K>> {
	
	K laClau();
    K laClau(K clau);

    V elValor();
    V elValor(V valor);
    
    boolean tenirClau(K clau);
    boolean tenirValor(V valor);
    
    V obtenirValor(K clau);
    K obtenirClau(V valor);
    
    Entrada<K,V> establirValor(K clau, V valor);
    Entrada<V,K> establirClau(V valor, K clau);

    Entrada<K,V> obtenirPareSegonsClau(K clau);
    Entrada<V,K> obtenirFillSegonsValor(V valor);
    
    int índexDeClau(K clau);
    int índexDeValor(V valor);
    
    V reemplaçarValor(K clau, V valor);
    K reemplaçarClau(V valor, K clau);

    boolean reemplaçarValor(K clau, V anticValor, V nouValor);
    boolean reemplaçarClau(V valor, K antigaClau, K novaClau);
    
    V remoureValor(K clau);
    K remoureClau(V clau);
    
    boolean remoureValor(K clau, V valor);
    boolean remoureClau(V valor, K clau);

    Comparador<K,V> membre();
    Comparador<K,V> membre(K clau, V valor);
    
    interface Comparador<K,V> 
    	extends Genital<Entrada<K,V>,Entrada<V,K>> {
    	
    	void posar(K clau, V valor);
    }
}
