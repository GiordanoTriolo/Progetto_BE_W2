package library.element;

public class Book extends LibraryElement {

	private String author;
	private String genre;
	
	public Book(String isbn, String title, int year, int pageNum, String author, String genre) {
		super(isbn, title, year, pageNum);
		this.author = author;
		this.genre = genre;
	}
	
	public Book(String isbn, String title, int year, int pageNum) {
		super(isbn, title, year, pageNum);
	}


	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "FOUND ------- Book [author: " + author + ", genre: " + genre + " - " + super.toString() + "] ------- \n";
	}
		
}
