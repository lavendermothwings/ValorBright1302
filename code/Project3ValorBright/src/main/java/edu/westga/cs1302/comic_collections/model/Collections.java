package edu.westga.cs1302.comic_collections.model;

/** Stores information for a collections.
 * 
 * @author Valor Bright
 * @version Fall 2025
 */
public class Collections {
private String name;

/** Create a new Collection with the provided information.
 * 
 * @precondition checkName(name)
 * 
 * @param name name of the contact
 */
public Collections(String name) {
	if (!Collections.checkName(name)) {
		throw new IllegalArgumentException("name is not valid");
	}
	this.name = name;
}

/** Checks if a name matches standard style
 * Must have at least one character and only contain letters and numbers
 * 
 * @precondition none
 * @postcondition none
 * 
 * @param name the text to be checked
 * @return true 	if name matches expected style
 * 		   false 	if name does not match expected style
 */
public static boolean checkName(String name) {
	return name != null && name.matches("[a-zA-Z0-9]+");
}

/** Return the name for the Collection
 * 
 * @precondition none
 * @postcondition none
 * 
 * @return the name for the Collection
 */
public String getName() {
	return this.name;
}

/** Return a string representation of the object state.
 * 
 * @precondition none
 * @postcondition none
 * 
 * @return a string representation of the object state
 */
@Override
public String toString() {
	return this.name;
}
}
