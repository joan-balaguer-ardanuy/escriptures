package escriptures;

import java.io.Serial;

import escriptures.gènesi.Fill;

public class Carta extends Fill<Salm,Passatge> {
	@Serial
	private static final long serialVersionUID = -8906224501983865614L;

	@Override
	public String nom() {
		return null;
	}
	
	public Carta() {
		super();
	}
	public Carta(Gènere paritat) {
		super(paritat);
	}
	public Carta(Gènere paritat, Salm clau, Passatge valor) {
		super(Llibre.class, paritat, clau, valor);
	}
	public Carta(Carta pare) {
		super(pare);
	}
	public Carta(Carta pare, Salm clau, Passatge valor) {
		super(Llibre.class, pare, clau, valor);
	}
	public Carta(Carta sobirana, Gènere paritat) {
		super(sobirana, paritat);
	}
	public Carta(Carta sobirana, Gènere paritat, Salm clau, Passatge valor) {
		super(Llibre.class, sobirana, paritat, clau, valor);
	}
	
	@Override
	public int compareTo(Entrada<Passatge,Salm> o) {
		return 0;
	}
	@Override
	public void run() {
		
	}
}