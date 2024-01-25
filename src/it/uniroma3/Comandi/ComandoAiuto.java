package it.uniroma3.Comandi;

import it.uniroma3.DiaDia.*;

public class ComandoAiuto implements Comando {
	
	private static final String[] elencoComandi = {"vai", "prendi", "posa", "guarda",
			"aiuto", "fine"};
	
	public ComandoAiuto() {}
	
	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Elenco comandi: ");
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
	}
}
