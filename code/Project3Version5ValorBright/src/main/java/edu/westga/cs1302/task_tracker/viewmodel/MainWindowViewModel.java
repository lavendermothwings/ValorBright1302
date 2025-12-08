package edu.westga.cs1302.task_tracker.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.task_tracker.model.Collections;
import edu.westga.cs1302.task_tracker.model.ComicBook;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class MainWindowViewModel {
	private StringProperty name;
	private ListProperty<Collections> collection;
	private ListProperty<ComicBook> comicBooks;
	
	
	
	public MainWindowViewModel() {
		this.name = new SimpleStringProperty("");
		this.collection = new SimpleListProperty<Collections>(FXCollections.observableList(new ArrayList<Collections>()));
		
	}
	
	
	public StringProperty getName() {
		return this.name;
	}

	
	public void addCollection() {
		Collections collection = new Collections(this.name.get());
		this.collection.add(collection);
	}
	
	public void selectCollection() {
		
	}
	
	public void removeCollection() {
	
	}
	
	
	public void cancelAddComic() {
		
	}
	
	public void confirmAddComic() {
		
	}
	
	public ListProperty<Collections> getCollections() {
		return this.collection;
	}
	
	public ListProperty<ComicBook> getComicBooks() {
		return this.comicBooks;
	}
	
	
}
