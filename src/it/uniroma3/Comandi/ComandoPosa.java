package it.uniroma3.Comandi;

import it.uniroma3.Ambienti.Stanza;
import it.uniroma3.Attrezzi.Attrezzo;
import it.uniroma3.DiaDia.*;
import it.uniroma3.Giocatore.Borsa;

public class ComandoPosa implements Comando {
	
	private String nomeAttrezzo;
	
	public ComandoPosa(String p) {
		this.nomeAttrezzo = p;
	}

	public String getParametro() {
		return this.nomeAttrezzo;
	}
	
	@Override
	public void esegui(Partita partita, IO io) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Borsa borsaPartita = partita.getGiocatore().getBorsa();
		if (borsaPartita.hasAttrezzo(this.getParametro())) {
			Attrezzo attrezzoDaPosare = borsaPartita.getAttrezzo(this.getParametro());
			if (stanzaCorrente.addAttrezzo(attrezzoDaPosare)) {
				borsaPartita.removeAttrezzo(this.getParametro());
				io.mostraMessaggio("Attrezzo "+this.getParametro()+" posato!");
			}
			else
				io.mostraMessaggio("La stanza è piena di oggetti non è possibile posarlo.");
		}
		else 
			io.mostraMessaggio("Non possiedi questo attrezzo.");
	}
}
