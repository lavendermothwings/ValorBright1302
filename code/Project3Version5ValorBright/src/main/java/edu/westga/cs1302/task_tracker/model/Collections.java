package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;

/** Stores basic information for a Collection
 * 
 * @author Valor Bright
 * @version Fall 2025
 */
public class Collections {
	private String name;
	
	/** Create a new collection 
	 * 
	 * @precondition name != null && !name.isEmpty()
	 * 
	 * @param name of the collection
	 */
	public Collections(String name) {
		if (name == null) {
			throw new IllegalArgumentException("name must not be null");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name must not be empty");
		}
		this.name = name;
	}
	
	/** Return the name of the collection
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the collection
	 */
	public String getName() {
		return this.name;
	}
	
	/** Gets comic books from list
	 * 
	 * @return ArrayList that is empty
	 */
			
	public ArrayList<ComicBook> getComicBooks() {
		ArrayList<ComicBook> emptyList = new ArrayList<ComicBook>();
		return emptyList;
	}
	
	/** Returns the name of the collection to represent the collection as a String
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the collection
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
