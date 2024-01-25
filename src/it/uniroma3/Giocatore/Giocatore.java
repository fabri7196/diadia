package it.uniroma3.Giocatore;

public class Giocatore {
	
	public final static int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;

	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Borsa getBorsa() {
		return borsa;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
	public String getDescrizione() {
		return this.toString();
	}
	
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("Cfu rimanenti -> "+this.getCfu());
		risultato.append("\n"+this.borsa.getDescrizione());
		return risultato.toString();
	}
}
