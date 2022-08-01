package library.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import library.element.Book;
import library.element.LibraryElement;
import library.element.Magazine;
import library.element.model.Periodicity;

public class Catalogue {

	private static final Logger log = LoggerFactory.getLogger(Catalogue.class);
	
	private Map<String, LibraryElement> archive = new HashMap<String, LibraryElement>();
	
	public void add(LibraryElement element) {
		if(element == null) {
			log.error("Insertion error, you are adding nothing");
		} else {
			archive.put(element.getIsbn(), element);
			log.info("Element added to archive. ISBN: {}", element.getIsbn());
		}
	}
	
	public void remove(String isbn) {
		LibraryElement removed = archive.remove(isbn);
		if(removed != null)
			log.info("Element removed from archive. ISBN: {}", removed.getIsbn());
		else 
			log.error("Element not found, check the isbn code again");
	}
	
	public void findIsbn(String isbn) {
		LibraryElement element = archive.get(isbn);
		if (element != null) {
			System.out.println(element);
		} else {
			log.error("Error, the isbn code {} isn't associated with any book or magazine", isbn);
		}
		
	}
	
	public void findYear(int year) {
		// Creo una lista di LibraryElement così da avere un appoggio 
		// per utilizzare l'if - else necessario per la validazione
		
		List<LibraryElement> list = new ArrayList<>();
		
		archive.values().stream()
			.filter(element -> year == element.getYear())
			.forEach(element -> list.add(element));
		
		if(list.size() != 0) {
			System.out.println(list.toString());
		} else {
			log.error("Sorry, we do not have any book or magazine published in {} in our archive", year);
		}
			
	}
	
	public void findAuthor(String author) {
		List<LibraryElement> list = new ArrayList<>();
		
		archive.values().stream()
			.filter(element -> element instanceof Book) 
			.map(element -> (Book) element)
			.filter(element -> author.equals(element.getAuthor()))
			.forEach(element -> list.add(element));
		
		if (list.size() != 0) {
			System.out.println(list.toString());
		} else {
			log.error("Sorry, we do not have any book written by {} in our archive", author);
		}
	}
	
	
	public void saveFile() {
		
		File file = new File("Project_BE_W2/archive.txt");
		
		String fileString = "";
		
		for(LibraryElement element : archive.values()){
			fileString += element.toString();
		}
		
		try {
			FileUtils.writeStringToFile(file, fileString);
			log.info("Savefile method successful");
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public void loadFile() {
		
		File file = new File("Project_BE_W2/archive.txt");
		
		try {
			String fileString = FileUtils.readFileToString(file);
			System.out.println(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		Catalogue catalogue = new Catalogue();
		
		Book book1 = new Book("B0001", "The Lord of the Rings", 1955, 1200, "J.R.R Tolkien", "Novel");
		Book book2 = new Book("B0002", "The Lordd of the Ringss", 1955, 1200, "J.R.R Tolkienn", "Novel");
		Book book3 = new Book("B0003", "The Lorddd of the Ringsss", 1955, 1200, "J.R.R Tolkiennn", "Novel");
		Magazine mag1 = new Magazine("M0001", "Focus", 2022, 60, Periodicity.MONTHLY);
		
		catalogue.add(null);
		catalogue.add(book1);
		catalogue.add(book2);
		catalogue.add(book3);
		catalogue.add(mag1);
		
		try {
			catalogue.saveFile();
			catalogue.loadFile();
			
			catalogue.findIsbn("M0001");
			catalogue.findIsbn("B008");
			catalogue.remove("11");
			catalogue.findYear(1955);
			catalogue.findYear(1935);
			catalogue.findAuthor("James Joyce");
			
		} catch (Exception e) {
			log.error("Error while writing to/reading from file");
		}
		
	}

}
