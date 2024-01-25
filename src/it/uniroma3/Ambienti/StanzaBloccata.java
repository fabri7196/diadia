package it.uniroma3.Ambienti;

public class StanzaBloccata extends Stanza {
	
	private String nomeDirezioneBloccata;
	private String nomeAttrezzoSbloccante;
	
	public StanzaBloccata(String nomeStanza, String direzione, String attrezzo) {
		super(nomeStanza);
		this.nomeDirezioneBloccata = direzione;
		this.nomeAttrezzoSbloccante = attrezzo;
	}

	@Override
	public Stanza getStanzaAdiacente(String dir) {
		boolean dirBloccataUguale = dir.equals(this.nomeDirezioneBloccata);
		boolean attrezzoPresente = super.hasAttrezzo(this.nomeAttrezzoSbloccante);
		
		if ((dirBloccataUguale && attrezzoPresente) || (!dirBloccataUguale))
			return super.getStanzaAdiacente(dir);
		else 
			return this;
	}
	
	@Override
	public String getDescrizione() {
		return super.getDescrizione() + "\nDirezione bloccata: " + this.nomeDirezioneBloccata + 
				"\nOggetto utile per lo sblocco: " + this.nomeAttrezzoSbloccante;
	}
}
