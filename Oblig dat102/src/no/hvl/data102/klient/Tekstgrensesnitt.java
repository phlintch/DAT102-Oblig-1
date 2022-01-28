package no.hvl.data102.klient;

import javax.swing.JOptionPane;

import no.hvl.data102.Film;
import no.hvl.data102.Filmarkiv;
import no.hvl.data102.Sjanger;
import no.hvl.data102.adt.FilmarkivADT;

public class Tekstgrensesnitt {
	// lese opplysningene om en FILM fra tastatur  
	 public Film lesFilm(FilmarkivADT filmarkiv){ 
	  Film nyFilm = new Film();
	  boolean godtatt = false;
	  while(!godtatt) {
		  int nr = Integer.parseInt(JOptionPane.showInputDialog("Skriv filmnr: "));
		  if (!filmarkiv.finnes(nr)) {
			  nyFilm.setFilmnr(nr);
			  godtatt = true;
		  } else {
			  JOptionPane.showMessageDialog(null, "Filmnr er opptatt, prøv et annet.");
		  }
	  }
	  // public Film (int filmnr, String filmskaper, String Tittel, int year, Sjanger sjanger, String Filmselskap ) 
	  godtatt = false;
	  while (!godtatt) {
		  String fs = JOptionPane.showInputDialog("Skriv Filmskaper: ");
		  if (!fs.equals("")) {
			  nyFilm.setFilmskaper(fs);
			  godtatt = true;
		  } else {
			  JOptionPane.showMessageDialog(null, "Kan ikke være tom. ");
		  }
	  }
	  godtatt = false;
	  while (!godtatt) {
		  String T = JOptionPane.showInputDialog("Skriv Tittel: ");
		  if (!T.equals("")) {
			  nyFilm.setTittel(T);
			  godtatt = true;
		  } else {
			  JOptionPane.showMessageDialog(null, "Kan ikke være tom. ");
		  }
	  }
	  godtatt = false;
	  while (!godtatt) {
		  int year = Integer.parseInt(JOptionPane.showInputDialog("Skriv år: "));
		  if (year > 1900 && year < 2100) {
			  nyFilm.setYear(year);
			  godtatt = true;
		  } else {
			  JOptionPane.showMessageDialog(null, "Året var ikke godtatt.");
		  }
	  }
	  godtatt = false;
	  Sjanger[] sjangre = Sjanger.values();
	  int indeks = -1;
	  while (!godtatt) {
		  String sj = JOptionPane.showInputDialog("Skriv Sjanger: ");
		  boolean eksisterer = false;
		  for (int i = 0; i < sjangre.length; i++) {
			  if (sjangre[i].toString().toUpperCase().equals(sj.toUpperCase())) {
				  indeks = i;
				  eksisterer = true;
			  }
		  }
		  if (eksisterer) {
			  nyFilm.setSjanger(sjangre[indeks]);
			  
			  godtatt = true;
		  } else {
			  JOptionPane.showMessageDialog(null, "Finner ikke sjangeren "+sj+"\nHusk, sjangerene som finnes er: ");
			  String s = "";
			  for (int i = 0; i < sjangre.length; i++) {
				  s += sjangre[i].toString() + "\n";
			  }
			  JOptionPane.showMessageDialog(null, s);
		  }
	  }
	  godtatt = false;
	  while(!godtatt) {
		  String T = JOptionPane.showInputDialog("Skriv Filmselskap: ");
		  if (!T.equals("")) {
			  nyFilm.setFilmselskap(T);
			  godtatt = true;
		  } else {
			  JOptionPane.showMessageDialog(null, "Kan ikke være tom. ");
		  }
	  }
	  return nyFilm;
	 } 
	 
	 // vise en film med alle opplysninger på skjerm (husk tekst for sjanger) 
	 public void visFilm(Film film, FilmarkivADT arkiv) { 
		 int nr = film.getFilmnr();
		 arkiv.visFilm(nr);
		 
	 } 
	 
	 // Skrive ut alle Filmer med en spesiell delstreng i tittelen 
	 public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) { 
		 Film[] filmer = filma.soekTittel(delstreng);
		 for (int i = 0; i < filmer.length; i++) {
			visFilm(filmer[i], filma);
		 }
	 } 
	 
	 // Skriver ut alle Filmer av en produsent / en gruppe 
	 public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) { 
		 Film[] tab = filma.soekTittel("");
		 for (int i = 0; i < tab.length; i++) {
			 if (tab[i].getFilmskaper().toUpperCase().contains(delstreng.toUpperCase())) {
				 visFilm(tab[i], filma);
			 }
		 }
		 
	 } 
	 
	 // Skrive ut en enkel statistikk som inneholder antall Filmer totalt 
	 // og hvor mange det er i hver sjanger 
	 public void skrivUtStatistikk(FilmarkivADT filma) { 
		 System.out.println("Antall filmer totalt: " + filma.antall());
		 System.out.println("Antall sjangre: " + Sjanger.values().length);
		 Sjanger[] sj = Sjanger.values();
		 for (int i = 0; i < sj.length; i++) {
		 System.out.println("Antall filmer i: " + sj[i].toString()+ " : " + filma.antall(sj[i]));
		 }
	 } 
	 // ... Ev. andre metoder 
	 
	} 