package no.hvl.data102.klient;

import no.hvl.data102.Filmarkiv;
import no.hvl.data102.Filmarkiv2;
import no.hvl.data102.adt.FilmarkivADT;

public class KlientFilmarkiv { 
	 
	 public static void main(String[] args) { 
	  FilmarkivADT filma = new Filmarkiv();  // new Filmarkiv2(); for kjedet
	  Meny meny = new Meny(filma); 			 // par problemer med å vise filmer, må se på 
	  meny.start(); 
	 } 
	 
	} 
