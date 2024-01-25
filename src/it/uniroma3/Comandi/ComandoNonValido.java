package it.uniroma3.Comandi;

import it.uniroma3.DiaDia.*;

public class ComandoNonValido implements Comando {
	
	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Comando non valido, digitare 'aiuto' per vedere i comandi ammessi.");
	}
}
