package it.uniroma3.Comandi;
import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{

	private String nome;
	private String parametro;
	
	public FabbricaDiComandiFisarmonica() {}

	@Override
	public Comando costruisciComando(String istruzione) {
		
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
//		scannerDiParole.close();

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando

		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();  // seconda parola: parametro
		
		if (nomeComando == null)
			comando = new ComandoNonValido();
		else if (nomeComando.equals("vai")) 
			comando = new ComandoVai(parametro);
		else if (nomeComando.equals("prendi")) 
			comando = new ComandoPrendi(parametro);
		else if (nomeComando.equals("posa")) 
			comando = new ComandoPosa(parametro);
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else if (nomeComando.equals("aiuto")) 
			comando = new ComandoAiuto();
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else comando = new ComandoNonValido();
		
		return comando;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getParametro() {
		return this.parametro;
	}
	
	public boolean sconosciuto() {
		return (this.nome == null);
	}
}
