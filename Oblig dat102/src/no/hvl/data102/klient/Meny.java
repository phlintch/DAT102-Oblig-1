package no.hvl.data102.klient;

import javax.swing.JOptionPane;

import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;
import no.hvl.data102.adt.FilmarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;  
	 private FilmarkivADT filmarkiv;  
	 
	 public Meny(FilmarkivADT filmarkiv){ 
	  tekstgr = new Tekstgrensesnitt();  
	  this.filmarkiv = filmarkiv; 
	 } 
	  
	 public void start(){ 
		// public Film (int filmnr, String filmskaper, String Tittel, int year, Sjanger sjanger, String Filmselskap ) 
		 Film nr1 = new Film(1, "Sandra Grotle Dueland", "Git tutorial", 2022, Sjanger.ACTION, "Due Produksjoner");
		 Film nr2 = new Film(2, "Magnus Henningsen", "Floppy disc", 2000, Sjanger.DRAMA, "Due Produksjoner");
		 Film nr3 = new Film(3, "Stephen Spielberg", "IT", 1991, Sjanger.HISTORY, "Spielberg productions");
		 Film nr4 = new Film(4, "George Lucas", "Star Wars IV", 1978, Sjanger.SCIFI, "Lucas Arts");
		 Film nr5 = new Film(5, "Sandra Grotle Dueland", "Bio life", 2019, Sjanger.HISTORY, "Due Produksjoner");
		 filmarkiv.leggTilFilm(nr1);
		 filmarkiv.leggTilFilm(nr2);
		 filmarkiv.leggTilFilm(nr3);
		 filmarkiv.leggTilFilm(nr4);
		 filmarkiv.leggTilFilm(nr5);
		 boolean valgt = false;
		 while (!valgt) {
			 System.out.println();
			int valg =  valg(JOptionPane.showInputDialog("Hva vil du gjøre?\n skriv 'Hjelp' for muligheter"));
			 if (valg == -1) {
				 JOptionPane.showMessageDialog(null, "Feil, skriv Hjelp for muligheter.");
			 } else if (valg == 0) {
				 String tittel = JOptionPane.showInputDialog("Hvilken tittel vil du søke etter?\nHold feltet blankt om du vil ha alle filmer.");
				 tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, tittel);
			 } else if (valg == 1) {
				 String prod = JOptionPane.showInputDialog("Hvilken produsent vil du søke etter?");
				 tekstgr.skrivUtFilmProdusent(filmarkiv, prod);
			 } else if (valg == 2) {
				 tekstgr.skrivUtStatistikk(filmarkiv);
			 } else if (valg == 3) {
				 valgt = true;
			 } else if (valg == 4) {
				 JOptionPane.showMessageDialog(null, filmarkiv.antall());
			 } else if (valg == 5) {
				 boolean s = false;
				 while(!s) {
				 String sj = JOptionPane.showInputDialog("Hvilken sjanger vil du søke etter?\nSkriv 'sjangre' for å få en liste");
				 if (sj.toUpperCase().equals("SJANGRE")) {
					 Sjanger[] tab = Sjanger.values();
					 String retur = "Sjangre:\n";
					 	for (int i = 0; i < tab.length; i++) {
					 		retur += tab[i].toString() + "\n";
					 	}
					 	JOptionPane.showMessageDialog(null, retur);
				 } else {
					 Sjanger[] tab = Sjanger.values();
					 for (int i = 0; i < tab.length; i++) {
						 if (tab[i].toString().toUpperCase().equals(sj.toUpperCase())) {
							 JOptionPane.showMessageDialog(null, filmarkiv.antall(tab[i]));
							 s = true;
						 }
					 }
				 }
				 }
			 } else if (valg == 6) {
				 boolean godtatt = false;
				 String x = "";
				 while (!godtatt) {
				  x = JOptionPane.showInputDialog("Hva er filmnr til filmen du vil slette?");
				  int nr = Integer.parseInt(x);
					 if (!filmarkiv.finnes(nr)) {
						 JOptionPane.showMessageDialog(null, "Ikke godtatt / finnes ikke");
					 } else if (filmarkiv.finnes(nr)) {
						 JOptionPane.showMessageDialog(null, "Film slettet: " + filmarkiv.slettFilm(nr));
						 godtatt = true;
					 }
				 }

			 } else if (valg == 7) {
				 filmarkiv.leggTilFilm(tekstgr.lesFilm(filmarkiv));
			 } else if (valg == 8) {
				 String[] tab = new String[9];
				 tab[0] = "tittel";
				 tab[1] = "produsent";
				 tab[2] = "statistikk";
				 tab[3] = "avslutt";
				 tab[4] = "antall";
				 tab[5] = "sjanger antall";
				 tab[6] = "slett";
				 tab[7] = "ny";
				 tab[8] = "hjelp";
				 
				 String muligheter = "Muligheter: \n";
				 for (int i = 0; i< tab.length; i++) {
					 muligheter += tab[i] + " \n";
				 }
				 JOptionPane.showMessageDialog(null, muligheter);
			 } else {
				 JOptionPane.showMessageDialog(null, "Noe gikk feil.");
			 }
		 }
		 
	 } 
	 public int valg(String x) {
		 String[] tab = new String[9];
		 tab[0] = "tittel";
		 tab[1] = "produsent";
		 tab[2] = "statistikk";
		 tab[3] = "avslutt";
		 tab[4] = "antall";
		 tab[5] = "sjanger antall";
		 tab[6] = "slett";
		 tab[7] = "ny";
		 tab[8] = "hjelp";
		 for (int i = 0; i < tab.length; i++) {
		 if (x.toUpperCase().equals(tab[i].toUpperCase())) {
			 return i;
		 }
		 }
		 return -1;
	 }
	} 