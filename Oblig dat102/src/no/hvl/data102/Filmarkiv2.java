package no.hvl.data102;

import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT{
	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2() {
		antall = 0;
		
	}
	
	@Override
	public void visFilm(int nr) {
		LinearNode<Film> node = start;  
		if (finnes(nr)) {
			 for (int i = 0; i < antall; i++) {
				 if (node.getElement().getFilmnr() == nr) {
					 System.out.println(node.getElement().toString());
				 } else {
					 node = node.getNeste();
				 }
			 }
		 }
	}


	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> Ny = new LinearNode<Film>(); 
		Ny.setElement(nyFilm);
		if (antall != 0) {
		Ny.setNeste(start);
		start = Ny;
		} else {
		start = Ny;
		start.setNeste(null);
		}
		antall++;
		}

	@Override
	public boolean slettFilm(int filmnr) {
		LinearNode<Film> node = start;
		if (!finnes(filmnr)) {
			return false;
		} else {
			LinearNode<Film> forgje = start;
			for (int i = 0; i < antall; i++) {
				if (node.getElement().getFilmnr() == filmnr) {
					if (node.equals(start)) {
						start = node.getNeste();
						antall--;
						return true;
					} else {
						forgje.setNeste(node.getNeste());
						antall--;
						return true;
					}
				} else {
					forgje = node;
					node = node.getNeste();
				}
			}
			return false;
		}
	}

	@Override
	public boolean finnes(int nr) {
		LinearNode<Film> forste = start;
		for (int i = 0; i < antall; i++) {
			if (forste.getElement().getFilmnr()==nr) {
				return true;
			} else {
				forste = forste.getNeste();
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] funn = new Film[antall];
		LinearNode<Film> node = start;
		int passende = 0;
		for (int i = 0; i < antall; i++) {
			if (node.getElement().getTittel().toUpperCase() == delstreng.toUpperCase()) {
				funn[passende] = node.getElement();
				passende++;	
			}
			node = node.getNeste();
		}
		Film[] retur = new Film[passende];
		for (int i = 0; i < passende; i++) {
			if (funn[i] != null) {
			retur[i] = funn[i];
			}
		}
		return retur;
	}

	@Override
	public int antall(Sjanger sjanger) {
		LinearNode<Film> node = start;
		int teller = 0;
		for (int i = 0; i < antall; i++) {
			if (node.getElement().getSjanger() == sjanger) {
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
