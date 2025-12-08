package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;

/** Stores basic information for a Task
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Collections {
	private String name;
	
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
	
	public ArrayList<Collections> getComicBooks(){
		ArrayList<Collections> emptyList = new ArrayList<Collections>();
		return emptyList;
	}
	
	public Collections addCollection(Collections newCollection) {
		if (newCollection == null) {
			throw new IllegalArgumentException("subtask must not be null");
		}
		Collections collection = new Collections(this.getName());
		collection.addCollection(newCollection);
		return collection;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
