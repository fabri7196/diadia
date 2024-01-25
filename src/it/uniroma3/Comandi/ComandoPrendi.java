package it.uniroma3.Comandi;

import it.uniroma3.Ambienti.Stanza;
import it.uniroma3.Attrezzi.Attrezzo;
import it.uniroma3.DiaDia.*;
import it.uniroma3.Giocatore.Borsa;

public class ComandoPrendi implements Comando{
	
	private String nomeAttrezzo;
	
	public ComandoPrendi(String attrezzo) {
		this.nomeAttrezzo = attrezzo;
	}
	
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void esegui(Partita partita, IO io) {
		Stanza corrente = partita.getStanzaCorrente();
		Attrezzo attrezzoPreso = corrente.getAttrezzo(this.nomeAttrezzo);
		if ( attrezzoPreso != null ) {
			corrente.removeAttrezzo(attrezzoPreso);
			Borsa borsaPartita = partita.getGiocatore().getBorsa();
			borsaPartita.addAttrezzo(attrezzoPreso);
			io.mostraMessaggio("Attrezzo "+this.nomeAttrezzo+" preso!");
		}
		else 
			io.mostraMessaggio("Attrezzo "+this.nomeAttrezzo+" non presente.");
	}	
}