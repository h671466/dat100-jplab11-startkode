package no.hvl.dat100.jplab11.oppgave4;

import no.hvl.dat100.jplab11.oppgave3.Blogg;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
 
		
		try {		

		PrintWriter skriver = new PrintWriter(mappe + filnavn);
		skriver.print(samling.toString());
		skriver.close();
		return true;

		} catch(FileNotFoundException e) {System.out.println("File not found!");

	    }

		return false;

	}
}