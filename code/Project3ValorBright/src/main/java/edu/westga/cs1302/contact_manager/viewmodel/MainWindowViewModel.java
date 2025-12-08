package edu.westga.cs1302.contact_manager.viewmodel;


import java.util.ArrayList;
import java.util.Map;

import edu.westga.cs1302.contact_manager.model.Collections;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/** View model for the MainWindow view
 * 
 * @author Valor Bright
 * @version Fall 2025
 */
public class MainWindowViewModel {
	private StringProperty name;
	private ListProperty<Collections> collection;
	private Map<String, Collections> nameMap;
	
	
	public MainWindowViewModel() {
	this.name = new SimpleStringProperty("");
	this.collection = new SimpleListProperty<Collections>(FXCollections.observableList(new ArrayList<Collections>()));
	}

	/** Adds a new collection
	 * 
	 * @precondition none
	 * @postcondition a new contact with name provided has been added
	 * 
	 * @throws IllegalArgumentException if name is not valid (see Contact class)
	 */
	public void addContact() throws IllegalArgumentException {
		Collections collection = new Collections(this.name.get());
		
	if (this.nameMap.containsKey(collection.getName())) {
			throw new IllegalArgumentException("Name is already in list");
		} else {
		
		this.collection.add(collection);
		this.nameMap.put(collection.getName(), collection);
		}
		
	}
	
	/** Return the name property used when adding a contact
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name property used when adding a contact
	 */
	public StringProperty getName() {
		return this.name;
	}
}
