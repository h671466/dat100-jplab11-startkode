package no.hvl.dat100.jplab11.oppgave3;

import java.util.Arrays;

import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {

	protected Innlegg[] innleggtabell;
	protected int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return this.nesteledig;
		
	}
	
	public Innlegg[] getSamling() {
	    Innlegg[] samling = innleggtabell;
	    return samling;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
        for(int i = 0; i < innleggtabell.length; i++) {
        if (innleggtabell[i] != null) {
		if(innleggtabell[i].erLik(innlegg)) {
			return i;
		}
        }
        }
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		if (finnInnlegg(innlegg) >= 0) {
			return true;
		}
		else return false;
	}

	public boolean ledigPlass(){
		if(this.nesteledig < innleggtabell.length ) {
			return true;
		}
		else return false;		
	}
	
	public boolean leggTil(Innlegg innlegg) { 
		if(ledigPlass() && !finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		else return false;
	}
	
	public String toString() {
		String tabellData = this.nesteledig + "\n";
		for(int i = 0; i < this.nesteledig; i++) {
			tabellData += innleggtabell[i].toString();
		}
		return tabellData;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		innleggtabell = Arrays.copyOf(innleggtabell, innleggtabell.length * 2);
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if(!finnes(innlegg)) {
			if(ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
			}
			else {
				utvid();
				innleggtabell[nesteledig] = innlegg;
				nesteledig++;
				return true;
			}
		}
		else return false;	
	}
	
	public boolean slett(Innlegg innlegg) {
		if(finnes(innlegg)) {
		int pos = finnInnlegg(innlegg);
		nesteledig--;
		innleggtabell[pos] = innleggtabell[nesteledig];
		innleggtabell[nesteledig] = null;
		return true;
		}
		else return false;
		
	}
	
	public int[] search(String keyword) {
		int[] matches = new int[nesteledig];
		int mch = 0;
		for (int i = 0; i < nesteledig; i++) {
			if(innleggtabell[i] instanceof Bilde || innleggtabell[i] instanceof Tekst) {
				if (((Tekst) innleggtabell[i]).getTekst().contains(keyword)) {
					matches[mch] = i;
					mch++;
				}
			}
		}
		return matches;

	}
}