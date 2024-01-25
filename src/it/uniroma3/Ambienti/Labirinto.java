package it.uniroma3.Ambienti;

import it.uniroma3.Attrezzi.Attrezzo;

/**
  * Questa classe crea il labirinto, ovvero la mappa del gioco.
  * Impostando anche, la stanza corrente e la stanza vincente.
  */

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	public Labirinto() {
		this.creaLabirinto();
	}
	
	/**
     * Crea tutte le stanze e le porte di collegamento
     */
	public void creaLabirinto() {
		
		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo chiave = new Attrezzo("chiave",2);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza aulaN9 = new StanzaBuia("Aula N9","lanterna");
		Stanza aulaN8 = new StanzaBloccata("Aula N8","est","chiave");
		Stanza aulaN7 = new Stanza("Aula N7");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		laboratorio.impostaStanzaAdiacente("nord", aulaN9);
		aulaN9.impostaStanzaAdiacente("sud", laboratorio);
		aulaN9.impostaStanzaAdiacente("est", aulaN8);
		aulaN8.impostaStanzaAdiacente("ovest", aulaN9);
		aulaN8.impostaStanzaAdiacente("est", aulaN7);
		aulaN7.impostaStanzaAdiacente("ovest", aulaN8);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		aulaN11.addAttrezzo(chiave);

		// il gioco comincia nell'atrio
        this.stanzaIniziale = atrio;  
		this.stanzaVincente = biblioteca;
	}
	
	/**
	 * Restituisce la stanza corrente.
	 * @return
	 */
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	/**
	 * Restituisce la stanza vincente.
	 * @return
	 */
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
}
