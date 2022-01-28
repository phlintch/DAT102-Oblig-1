package no.hvl.data102;

import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	public Film[] filmarkiv;
	public int antall;

	public Filmarkiv() {
		filmarkiv = new Film[1];
		antall  = 0;
	}

	public Filmarkiv(int lengde) {
		filmarkiv = new Film[lengde];
		antall = 0;
	}

	@Override
	public void visFilm(int nr) {
		System.out.println("test");
		boolean funnet = false;
		if (finnes(nr)) {
		for (int i = 0; i < antall && !funnet; i++) {
			if (filmarkiv[i].getFilmnr() == nr) {
				System.out.println(filmarkiv[i].toString());
				funnet = true;
			}
		}}
		else if (!finnes(nr)) {
			System.out.println(nr + " finnes ikke i arkivet.");
		}
		
	}

	public boolean finnes(int nr) {
		for (int i = 0; i < antall; i++) {
			if (nr == filmarkiv[i].getFilmnr()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall < filmarkiv.length) {
			filmarkiv[antall] = nyFilm;
			antall++;
		} else {
			Film[] temp = new Film[filmarkiv.length * 2];
			for (int i = 0; i < filmarkiv.length; i++) {
				temp[i] = filmarkiv[i];
			}
			filmarkiv = temp;
			leggTilFilm(nyFilm);
		}

	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean x = false;
		for (int i = 0; i < antall; i++) {
			if (!x && filmarkiv[i].getFilmnr() == filmnr) {
				x = true;
			}
			if (x) {
				filmarkiv[i] = filmarkiv[i+1];
			}
			
		}
		antall--;
		trimTab(filmarkiv, antall);
		return x;
	}

	private Film[] trimTab(Film[] tab, int n) {
		// n er antall elementer
		Film[] nytab = new Film[n];
		int i = 0;
		while (i < n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] retur = new Film[antall];
		int teller = 0;
		for (int i = 0; i < antall; i++) {
			if (filmarkiv[i] == null) {
			} else if (filmarkiv[i].getTittel().toUpperCase().contains(delstreng.toUpperCase())) {
				retur[teller] = filmarkiv[i];
				teller++;
			}
		}
		Film[] FRetur = new Film[teller];
		for (int i = 0; i < teller; i++) {
			FRetur[i] = retur[i];
		}
		return FRetur;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int teller = 0;
		for (int i = 0; i < antall; i++) {
			if (filmarkiv[i].getSjanger() == sjanger) {
				teller++;
			}
		}
		return teller;
	}

	@Override
	public int antall() {

		return antall;
	}

}
