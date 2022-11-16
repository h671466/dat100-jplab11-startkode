package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.oppgave1.*;

public class Tekst extends Innlegg {

	private String tekst;
	
	public Tekst () {
		
	}
	
	public Tekst(int id, String bruker, String dato, String tekst) {
		this(id, bruker, dato, 0, tekst);	
	}
	
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
		super(id, bruker, dato, likes);
		this.tekst = tekst;
	}
	
	public String getTekst() {
		return tekst;

	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public String toString() {
		return "TEKST\n" + this.getId()+ "\n" + this.getBruker() + "\n" + this.getDato() + "\n" + this.getLikes() + "\n" + this.tekst + "\n";

	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
			
		return "<h2>" + this.getBruker() + "@" + this.getDato() + " [" + this.getLikes() + "]<h2>\n"+
				"<p>" + this.getTekst() + "<p>"; 
				
				
	}
}