package no.hvl.data102;

import no.hvl.data102.adt.ADTFilm;

public class Film implements ADTFilm{

	public int filmnr;
	public String filmskaper;
	public String Tittel;
	public int year;
	public Sjanger sjanger;
	public String Filmselskap;

		public Film () {
			
		}
		
		public Film (int filmnr, String filmskaper, String Tittel, int year, Sjanger sjanger, String Filmselskap ) {
			this.filmnr = filmnr;
			this.filmskaper = filmskaper;
			this.Tittel = Tittel;
			this.year = year;
			this.sjanger = sjanger;
			this.Filmselskap = Filmselskap;
		}
		public int getFilmnr() { return filmnr;	}
		public void setFilmnr (int filmnr) { this.filmnr = filmnr; }
		public String getFilmskaper() { return filmskaper; }
		public void setFilmskaper(String filmskaper) { this.filmskaper = filmskaper; }
		public String getTittel() { return Tittel; }
		public void setTittel(String Tittel) { this.Tittel = Tittel; }
		public int getYear() { return year; }
		public void setYear(int year) { this.year = year; }
		public Sjanger getSjanger() { return sjanger; }
		public void setSjanger(Sjanger sjanger) { this.sjanger = sjanger; }
		public String getFilmselskap() { return Filmselskap; }
		public void setFilmselskap(String Filmselskap) { this.Filmselskap = Filmselskap; }
		public String toString() {
			return "Nr: " + getFilmnr() + " Filmskaper: " + getFilmskaper() + " Tittel: "+ getTittel() + " År: " + getYear() + " Sjanger: " + getSjanger().toString() + " Filmselskap: " + getFilmselskap();
		}
		@Override
		public boolean Equals(Film a, Film b) {
			return (a.getFilmnr() == b.getFilmnr());
		}
		@Override 
		public int hashCode() { 
		    Integer temp = filmnr; 
		    return temp.hashCode(); 
		} 
		 
	
}
