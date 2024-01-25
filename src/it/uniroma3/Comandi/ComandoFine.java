package it.uniroma3.Comandi;

import it.uniroma3.DiaDia.*;

public class ComandoFine implements Comando {
	
	public static final String MESSAGGIO_FINE = "Grazie di aver giocato!";
	
	public ComandoFine() {}
	
	@Override
	public void esegui(Partita partita, IO io) {
		partita.setFinita();
		io.mostraMessaggio(MESSAGGIO_FINE);  // si desidera smettere
	}
}
