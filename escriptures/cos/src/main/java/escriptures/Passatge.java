package escriptures;

import java.io.Serial;

import escriptures.gènesi.Pare;

public class Passatge extends Pare<Verset,Litúrgia> {
	@Serial
	private static final long serialVersionUID = 1037425553052355272L;

	@Override
	public String nom() {
		return null;
	}

	public Passatge() {
		super();
	}
	public Passatge(Gènere paritat) {
		super(paritat);
	}
	public Passatge(Gènere paritat, Verset clau, Litúrgia valor) {
		super(Salm.class, paritat, clau, valor);
	}
	public Passatge(Passatge pare) {
		super(pare);
	}
	public Passatge(Passatge pare, Verset clau, Litúrgia valor) {
		super(Salm.class, pare, clau, valor);
	}
	public Passatge(Passatge senyor, Gènere paritat) {
		super(senyor, paritat);
	}
	public Passatge(Passatge senyor, Gènere paritat, Verset clau, Litúrgia valor) {
		super(Salm.class, senyor, paritat, clau, valor);
	}

	@Override
	public int compareTo(Entrada<Litúrgia,Verset> o) {
		return 0;
	}
	@Override
	public void run() {
		
	}
}