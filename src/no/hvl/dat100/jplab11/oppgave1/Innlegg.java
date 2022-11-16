package no.hvl.dat100.jplab11.oppgave1;

public abstract class Innlegg {
	
	private int id;
	private String bruker;
	private String dato;
	private int likes;
	
	public Innlegg() {
		
	}
	
	public Innlegg(int id, String bruker, String dato) {
         this.id = id;
         this.bruker = bruker;
         this.dato = dato;
         this.likes = 0;
	}

	public Innlegg(int id, String bruker, String dato, int likes) {
		 this.id = id;
         this.bruker = bruker;
         this.dato = dato;
         this.likes = likes;
	}
	
	public String getBruker() {
		return bruker;	 
	}

	public void setBruker(String bruker) {
		this.bruker = bruker;
	}

	public String getDato() {
		return dato;
		
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public void doLike () {
		likes += 1;
	}
	
	public boolean erLik(Innlegg innlegg) {
		if(innlegg.getId() == this.id) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return id + "\n" + bruker + "\n" + dato + "\n" + likes + "\n";
				
	}

	public String toHTML() {
		
		return "<h2>" + this.getBruker() + "@" + this.getDato() + " [" + this.getLikes() + "]<h2>\n"; 
	}
}