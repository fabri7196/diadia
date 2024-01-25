package it.uniroma3.Ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.Attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo. Una stanza e' un luogo
 * fisico nel gioco. E' collegata ad altre stanzeAdiacenti attraverso delle uscite. Ogni
 * uscita e' associata ad una direzione.
 * 
 * @author docente di POO
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final public int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private int numeroAttrezzi; // contatore di riempimento dell'array sopra.
	private List<Attrezzo> attrezzi;
	private Map<String,Stanza> stanzeAdiacenti;

	/**
	 * Crea una stanza. Non ci sono stanzeAdiacenti adiacenti, non ci sono attrezzi.
	 * 
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.numeroAttrezzi = 0;
		this.attrezzi = new ArrayList<>();
		this.stanzeAdiacenti = new HashMap<>();
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza    stanza adiacente nella direzione indicata dal primo
	 *                  parametro.
	 */

//	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
//		boolean aggiornato = false;
//		for (int i = 0; i < this.numeroStanzeAdiacenti; i++)
//			if (this.direzioni.get(i).equals(direzione)) {
//				this.stanzeAdiacenti.add(i, stanza);
//				aggiornato = true;
//			}
//		if (!aggiornato)
//			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
//				this.direzioni.add(this.numeroStanzeAdiacenti, direzione);
//				this.stanzeAdiacenti.add(this.numeroStanzeAdiacenti, stanza);
//				this.numeroStanzeAdiacenti++;
//			}
//	}
	
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		if (direzione.equals("nord") || direzione.equals("sud") || 
				direzione.equals("est") || direzione.equals("ovest")) 
			this.stanzeAdiacenti.put(direzione, stanza);
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * 
	 * @param direzione
	 */

//	public Stanza getStanzaAdiacente(String direzione) {
//		Stanza stanza = null;
//		for (int i = 0; i < this.numeroStanzeAdiacenti; i++)
//			if (this.direzioni.get(i).equals(direzione))
//				stanza = this.stanzeAdiacenti.get(i);
//		return stanza;
//	}
	
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanzaAdiacente = null;
		stanzaAdiacente = this.stanzeAdiacenti.get(direzione);
		return stanzaAdiacente;
	}

	/**
	 * Restituisce la nome della stanza.
	 * 
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * 
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}
	
	/**
	 * Restituisce il numero delle stanze adiacenti.
	 * 
	 * @return numero stanze adiacenti
	 */
	
	public int getNumeroStanzeAdiacenti() {
		return this.stanzeAdiacenti.size();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * 
	 * @return la collezione di attrezzi nella stanza.
	 */

	public List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * 
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.attrezzi.add(attrezzo);
			this.numeroAttrezzi++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza, stampadone la
	 * descrizione, le uscite e gli eventuali attrezzi contenuti
	 * 
	 * @return la rappresentazione stringa
	 */

//	public String toString() {
//		StringBuilder risultato = new StringBuilder();
//		risultato.append(this.nome);
//		risultato.append("\nUscite: ");
//		Iterator<String> iteratoreDirezioni = this.direzioni.iterator();
//		while (iteratoreDirezioni.hasNext()) {
//			String direzioneDaStampare = iteratoreDirezioni.next();
//			risultato.append(" " + direzioneDaStampare);
//		}
//		risultato.append("\nAttrezzi nella stanza: ");
//		Iterator<Attrezzo> iteratoreAttrezzi = this.attrezzi.iterator();
//		while (iteratoreAttrezzi.hasNext()) {
//			Attrezzo attrezzoDaStampare = iteratoreAttrezzi.next();
//			risultato.append(attrezzoDaStampare + " ");
//		}
//		return risultato.toString();
//	}
	
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		
		Set<String> dir = this.getDirezioni();
		risultato.append(dir);
		
		risultato.append("\nAttrezzi nella stanza: ");
		Iterator<Attrezzo> iteratoreAttrezzi = this.attrezzi.iterator();
		while (iteratoreAttrezzi.hasNext()) {
			Attrezzo attrezzoDaStampare = iteratoreAttrezzi.next();
			risultato.append(attrezzoDaStampare + " ");
		}
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * 
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */

	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato = false;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			if (iteratore.next().getNome().equals(nomeAttrezzo))
				trovato = true;
		}
		return trovato;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * 
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza. null se l'attrezzo non e' presente.
	 */

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			Attrezzo attrezzoInLista = iteratore.next();
			if(attrezzoInLista.getNome().equals(nomeAttrezzo))
				attrezzoCercato = attrezzoInLista;
		}
		return attrezzoCercato;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * 
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(this.numeroAttrezzi == 0)
			return false;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			Attrezzo attrezzoInLista = iteratore.next();
			if(attrezzoInLista.getNome().equals(attrezzo.getNome())) {
				iteratore.remove();
				this.numeroAttrezzi--;
				return true;
			}
		}
		return false;
	}
		
	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}
}