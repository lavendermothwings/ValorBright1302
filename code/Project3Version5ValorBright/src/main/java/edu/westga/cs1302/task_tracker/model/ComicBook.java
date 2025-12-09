package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;

/** Comic that is added to colleciton
 * 
 * @author Valor Bright
 * @version Fall 2025
 * 
 */
public class ComicBook {
	private String name;
	private ArrayList<ComicBook> listOfComicBooks;
	
	/** Create a new ComicBook class with the comic book information
	 * 
	 * @precondition name != null && !name.isEmpty() &&
	 * 
	 * @param name name of the comic book
	 * @param number number of the issue of comic book
	 */
	public ComicBook(String name, String number) {
		
		if (name == null) {
			throw new IllegalArgumentException("name must not be null");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name must not be empty");
		}
		if (!ComicBook.checkNumber(number)) {
			throw new IllegalArgumentException("number must be a digit");
		}
		if (number.isEmpty()) {
			throw new IllegalArgumentException("number must not be empty");
		}
	
		this.listOfComicBooks = new ArrayList<ComicBook>();
		this.name = name;
		
	}
	
	/** Checks number of issue
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param number number of comic issue
	 * @return	true if number matches
	 * 			false if number does not
	 */
	public static boolean checkNumber(String number) {
		String numberReq = "\\d";
		return number.matches(numberReq);
	}
	
	/** Get the list of comics
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return this.listOfComicBooks a list of comics
	 */
	
	public ArrayList<ComicBook> getComicBooks() {
	
		return this.listOfComicBooks;
	}
	
	/** Adds comic to the list of comics
	 * 
	 * @precondition comic != null
	 * @postcondition size() == size()@pre+1
	 * 
	 * @param comic comic to be added
	 * 
	 * @return this itself
	 */
	
	public ComicBook addComicToCollection(ComicBook comic) {
		if (comic == null) {
			throw new IllegalArgumentException("comic must not be null");
		}
		this.listOfComicBooks.add(comic);
		
		return this;
	}
	
	/** Returns the name of the comic to represent the comic as a String
	 * 
	 * 
	 * @return name the name of the comic
	 */
	@Override
	public String toString() {
		return this.name;
	}
	
}