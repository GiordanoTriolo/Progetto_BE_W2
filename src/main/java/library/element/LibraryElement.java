package library.element;

public abstract class LibraryElement {
	
	private String isbn;
	private String title;
	private int year;
	private int pageNum;
	
	public LibraryElement(String isbn, String title, int year, int pageNum) {
		this.isbn = isbn;
		this.title = title;
		this.year = year;
		this.pageNum = pageNum;
	}
	
	public LibraryElement() {
	}


	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "[isbn: " + isbn + ", title: " + title + ", year: " + year + ", pages: " + pageNum + "]";
	}
	
}
