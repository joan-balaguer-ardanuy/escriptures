package escriptures;

import java.io.Serial;

import escriptures.gènesi.Pare;

public class Verset extends Pare<Paraula,Nom> {
	@Serial
	private static final long serialVersionUID = 3134129150208197379L;

	@Override
	public String nom() {
		return null;
	}
	
	public Verset() {
		super();
	}
	public Verset(Gènere paritat) {
		super(paritat);
	}
	public Verset(Gènere paritat, Paraula clau, Nom valor) {
		super(Litúrgia.class, paritat, clau, valor);
	}
	public Verset(Verset pare) {
		super(pare);
	}
	public Verset(Verset pare, Paraula clau, Nom valor) {
		super(Litúrgia.class, pare, clau, valor);
	}
	public Verset(Verset senyor, Gènere paritat) {
		super(senyor, paritat);
	}
	public Verset(Verset senyor, Gènere paritat, Paraula clau, Nom valor) {
		super(Litúrgia.class, senyor, paritat, clau, valor);
	}
	
	@Override
	public int compareTo(Entrada<Nom,Paraula> o) {
		return 0;
	}
	@Override
	public void run() {
		
	}
}