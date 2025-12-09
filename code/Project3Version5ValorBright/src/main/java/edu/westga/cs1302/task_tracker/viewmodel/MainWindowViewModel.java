package edu.westga.cs1302.task_tracker.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.task_tracker.model.Collections;
import edu.westga.cs1302.task_tracker.model.ComicBook;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/** Viewmodel for MainWindow
 * 
 * @author Valor Bright
 * @version Fall 2025
 */
public class MainWindowViewModel {
	private StringProperty name;
	private ListProperty<Collections> collection;
	private ListProperty<ComicBook> comicBooks;

	/** Initialize the components
	 * 
	 */
	public MainWindowViewModel() {
		this.name = new SimpleStringProperty("");
		this.collection = new SimpleListProperty<Collections>(FXCollections.observableList(new ArrayList<Collections>()));
		this.comicBooks = new SimpleListProperty<ComicBook>(FXCollections.observableList(new ArrayList<ComicBook>()));
	
	}
	
	/** Get the name of the collection
	 * 
	 * @return name name of collection
	 */
	public StringProperty getName() {
		return this.name;
	}

	/** Add collection 
	 * 
	 */
	public void addCollection() {
		Collections collection = new Collections(this.name.get());
		this.collection.add(collection);
	}

	/**Add comic book
	 * 
	 * @param newComicBook new comic to add to list
	 */
	public void addComic(ComicBook newComicBook) {
	
	}
	
	/** Confirms the adding of a comic
	 * 
	 */
	public void confirmAddComic() {
		
	}
	
	/**Gets the collection
	 * 
	 * @return collection list collection of comics
	 */
	public ListProperty<Collections> getCollections() {
		return this.collection;
	}
	
	/**Get comic books
	 * 
	 * @return list of comic books
	 */
	public ListProperty<ComicBook> getComicBooks() {
		
		return this.comicBooks;
	}
	
}
