package library.element;

import library.element.model.Periodicity;

public class Magazine extends LibraryElement {

	private Periodicity periodicity;

	public Magazine(String isbn, String title, int year, int pageNum, Periodicity periodicity) {
		super(isbn, title, year, pageNum);
		this.periodicity = periodicity;
	}

	public Magazine(String isbn, String title, int year, int pageNum) {
		super(isbn, title, year, pageNum);
	}

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		return "FOUND ------- Magazine [periodicity: " + periodicity + " - " + super.toString() + "] ------- \n";
	}
	
}
