package it.uniroma3.Ambienti;

public class StanzaBuia extends Stanza {
	protected static final String DESCRIZIONE_STANZA_BUIA = "Qui c'è buio pesto!";
	private String nomeAttrezzoPerVedere;
	
	public StanzaBuia(String nomeStanza, String nomeAttrezzo) {
		super(nomeStanza);
		this.nomeAttrezzoPerVedere = nomeAttrezzo;
	}

	@Override
	public String getDescrizione() {
		if (super.hasAttrezzo(this.nomeAttrezzoPerVedere))
			return super.getDescrizione();
		return DESCRIZIONE_STANZA_BUIA;
	}
}
