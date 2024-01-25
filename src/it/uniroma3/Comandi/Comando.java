package it.uniroma3.Comandi;

import it.uniroma3.DiaDia.IO;
import it.uniroma3.DiaDia.Partita;

public interface Comando {
	
	public void esegui(Partita partita, IO io);
}
