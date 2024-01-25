package it.uniroma3.Comandi;

import it.uniroma3.DiaDia.*;

public class ComandoGuarda implements Comando {
	
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Stanza corrente: "+partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Informazioni giocatore: \n"+partita.getGiocatore().getDescrizione());
	}
}