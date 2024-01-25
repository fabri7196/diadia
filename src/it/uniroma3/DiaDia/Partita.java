package it.uniroma3.DiaDia;

import it.uniroma3.Ambienti.Labirinto;
import it.uniroma3.Ambienti.Stanza;
import it.uniroma3.Giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private Giocatore giocatore;
	private boolean finita;
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.stanzaCorrente = this.labirinto.getStanzaIniziale();
		this.finita = false;
		this.giocatore = new Giocatore();
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public void setStanzaCorrente(Stanza stanza) {
		this.stanzaCorrente = stanza;
	}
	
	public Stanza getStanzaVincente() {
		return this.labirinto.getStanzaVincente();
	}
	
	public int getCfu() {
		return this.giocatore.getCfu();
	}
	
	public void setCfu(int cfu) {
		this.giocatore.setCfu(cfu);
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	
	public boolean giocatoreIsVivo() {
		return this.giocatore.getCfu() == 0;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || giocatoreIsVivo();
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

}
