package escriptures;

import java.io.Serial;

import escriptures.gènesi.Pare;

public class LaBíblia extends Pare<Alfa,Omega> {
	@Serial
	private static final long serialVersionUID = 3640331657208331844L;

	@Override
	public String nom() {
		return null;
	}

	public LaBíblia() {
		super();
	}
	public LaBíblia(Gènere paritat) {
		super(paritat);
	}
	public LaBíblia(Gènere paritat, Alfa clau, Omega valor) {
		super(Escriptures.class, paritat, clau, valor);
	}
	public LaBíblia(LaBíblia pare) {
		super(pare);
	}
	public LaBíblia(LaBíblia pare, Alfa clau, Omega valor) {
		super(Escriptures.class, pare, clau, valor);
	}
	public LaBíblia(LaBíblia senyor, Gènere paritat) {
		super(senyor, paritat);
	}
	public LaBíblia(LaBíblia senyor, Gènere paritat, Alfa clau, Omega valor) {
		super(Escriptures.class, senyor, paritat, clau, valor);
	}
	
	@Override
	public int compareTo(Entrada<Omega,Alfa> o) {
		return 0;
	}
	@Override
	public void run() {
		
	}
}