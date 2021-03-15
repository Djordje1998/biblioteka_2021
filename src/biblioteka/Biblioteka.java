package biblioteka;

import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterface;

/**
 * Ova klasa implementira interface BibliotekaInterface i predstavlja implementaciju preko liste.
 * @author Djordje Novakovic
 *
 */
public class Biblioteka implements BibliotekaInterface {

	/**
	 * Lista sa svim knjigama u biblioteci.
	 */
	private LinkedList<Knjiga> knjige = new LinkedList<>();
	
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if(knjiga==null) {
			throw new NullPointerException("Knjiga ne sme biti null");
		}
		if(knjige.contains(knjiga)) {
			throw new RuntimeException("Knjiga vec postoji");
		}
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if(knjiga==null || !knjige.contains(knjiga)) {
			throw new RuntimeException("Knjiga ne sme biti null i mora postojati u biblioteci");
		}
		knjige.remove(knjiga);

	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		if(autor==null && isbn==null && naslov==null && izdavac==null) {
			throw new RuntimeException("Morate uneti bar 1 kriterijum pretrage");
		}
		LinkedList<Knjiga> rezultat = new LinkedList<>();
		
		for (Knjiga knjiga : knjige) {
			if(knjiga.getNaslov().contains(naslov)) {
				rezultat.add(knjiga);
			}
		}
		return rezultat;
	}

}
