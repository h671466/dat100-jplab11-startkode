package no.hvl.dat100.jplab11.oppgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		
		Scanner scanner;
		try {
			scanner = new Scanner(new File(mappe+filnavn));
			int antall = scanner.nextInt();
			Blogg blogg = new Blogg(antall);
			
			while (scanner.hasNext()) {
				String next = scanner.nextLine();

				if (next.equals(TEKST)) {
					String id = scanner.nextLine();
					String brukernavn = scanner.nextLine();
					String dato = scanner.nextLine();
					String likes = scanner.nextLine();
					String tekst = scanner.nextLine();
					Tekst innlegg = new Tekst(Integer.parseInt(id),brukernavn,dato,Integer.parseInt(likes),tekst);
					blogg.leggTil(innlegg);
					
				} else if (next.equals(BILDE)) {
					String id = scanner.nextLine();
					String brukernavn = scanner.nextLine();
					String dato = scanner.nextLine();
					String likes = scanner.nextLine();
					String tekst = scanner.nextLine();
					String url = scanner.nextLine();
					Bilde innlegg = new Bilde(Integer.parseInt(id),brukernavn,dato,Integer.parseInt(likes),tekst,url);
					blogg.leggTil(innlegg);
				}
				
			}
			return blogg;
		} catch (FileNotFoundException e) {
			System.out.println("Fil ikke funnet.");
		} catch (Exception e) {
			System.out.println("Noe gikk galt.");
		}
		return null;
		
	}
}