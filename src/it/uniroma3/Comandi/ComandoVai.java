package it.uniroma3.Comandi;

import it.uniroma3.Ambienti.Stanza;
import it.uniroma3.DiaDia.*;

public class ComandoVai implements Comando {
	
	private String direzione;
	
	public ComandoVai(String d) {
		this.direzione = d;
	}
	
	@Override
	public void esegui(Partita partita, IO io) {
		Stanza corrente = partita.getStanzaCorrente();
		Stanza prossima = null;
		
		if(this.direzione == null) {
			io.mostraMessaggio("Dove vuoi andare? \nDevi specificare una direzione");
			return;
		}
		prossima = corrente.getStanzaAdiacente(this.direzione);
		if (prossima == null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		
		partita.setStanzaCorrente(prossima);
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getCfu()+" cfu rimanenti.");
	}
}
