package it.uniroma3.Giocatore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.uniroma3.Attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>(); // speriamo bastino...
		this.numeroAttrezzi = 0;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public String getDescrizione() {
		return this.toString();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi == 10)
			return false;
		this.attrezzi.add(attrezzo);
		this.numeroAttrezzi++;
		return true;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if (this.numeroAttrezzi == 0)
			return a;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			Attrezzo att = iteratore.next();
			if (att.getNome().equals(nomeAttrezzo)) {
				a = att;
				break;
			}
		}
		return a;
	}

	public int getPeso() {
		int peso = 0;
//		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
//		
//		while (iteratore.hasNext())
//			peso += iteratore.next().getPeso();
		for (Attrezzo a : this.attrezzi)
			peso += a.getPeso();
		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;

		if (this.numeroAttrezzi == 0) {
			System.out.println("Borsa vuota.");
			return a;
		}

		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			Attrezzo attrezzo = iteratore.next();
			if (attrezzo.getNome().equals(nomeAttrezzo)) {
				a = attrezzo;
				iteratore.remove();
				this.numeroAttrezzi--;
				break;
			}
		}

		if (a == null)
			System.out.println("Attrezzo non trovato.");
		return a;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			Iterator<Attrezzo> it = this.attrezzi.iterator();
			while (it.hasNext()) {
				s.append(it.next().toString() + " ");
			}
		} else
			s.append("Borsa vuota");
		return s.toString();
	}
}