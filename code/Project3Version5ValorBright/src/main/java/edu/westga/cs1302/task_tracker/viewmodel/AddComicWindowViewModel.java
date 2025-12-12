package edu.westga.cs1302.task_tracker.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.task_tracker.model.Collections;
import edu.westga.cs1302.task_tracker.model.ComicBook;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/** Viewmodel for AddComicWindow
 * 
 * @author Valor Bright
 * @version Fall 2025
 */
public class AddComicWindowViewModel {
	private StringProperty addComicName;
	private StringProperty addComicNumber;
	private ListProperty<ComicBook> comicBooks;
	private Collections collection;
	
	/** Initialize the AddComicWindowViewModel
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public AddComicWindowViewModel() {
		this.addComicName = new SimpleStringProperty("");
		this.addComicNumber = new SimpleStringProperty("");
		this.comicBooks = new SimpleListProperty<ComicBook>(FXCollections.observableList(new ArrayList<ComicBook>()));
		this.collection = new Collections("placeholder");
	}
	
	/** Returns the comic name property
	 * 
	 * @return addComicName name of comic
	 */
	public StringProperty getAddComicName() {
		return this.addComicName;
	}
	
	/** Returns the comic number property
	 * 
	 * @return addComicNumber
	 */
	public StringProperty getAddComicNumber() {
		return this.addComicNumber;
	}
	
	/** Removes comic
	 * 
	 */
	public void removeComic() {
		
	}
	
	/** Cancels Adding Comic
	 * 
	 */
	public void cancelAddComic() {
		//close window
	}
	
	/**Gets collection from selected collection from UI
	 * 
	 * @param collection selected collection from UI
	 * @return collection selected collection from UI
	 */
	public Collections getCollectionNeeded(Collections collection) {
		return collection;
	}
	
	/** Confirms Adding Comic
	 * 
	 */
	public void confirmAddComic() {
		ComicBook comic = new ComicBook(this.getAddComicName().get(), this.getAddComicNumber().get());
		this.collection.getComicBooks().add(comic);
	}
	
	/** Gets comic book list
	 * 
	 * @return comicBooks list
	 */
	public ListProperty<ComicBook> getComicBooks() {
		return this.comicBooks;
	}
}
