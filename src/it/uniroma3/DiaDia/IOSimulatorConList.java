package it.uniroma3.DiaDia;
import java.util.LinkedList;
import java.util.List;

public class IOSimulatorConList implements IO {
	
	private List<String> righeDaLeggere;
	private List<String> messaggiProdotti;

	public IOSimulatorConList(List<String> lista) {
		this.righeDaLeggere = lista;
		this.messaggiProdotti = new LinkedList<String>();
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiProdotti.add(messaggio);
	}

	@Override
	public String leggiRiga() {
		if(!this.righeDaLeggere.isEmpty())
			return this.righeDaLeggere.remove(0);
		else return null;
	}
	
	public String nextMessaggio() {
		if(hasNextMessaggio())
			return this.messaggiProdotti.remove(0);
		else return null;
	}

	public boolean hasNextMessaggio() {
		return !this.messaggiProdotti.isEmpty();
	}
}