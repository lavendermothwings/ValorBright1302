package edu.westga.cs1302.task_tracker.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.task_tracker.model.ComicBook;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

public class FindComicWindowViewModel {
	private StringProperty addComicName;
	private StringProperty addComicNumber;
	private ListProperty<ComicBook> comicBooks;
	
	
	public FindComicWindowViewModel() {
		this.addComicName = new SimpleStringProperty("");
		this.addComicNumber = new SimpleStringProperty("");
		this.comicBooks = new SimpleListProperty<ComicBook>(FXCollections.observableList(new ArrayList<ComicBook>()));
	}
	
	public StringProperty getAddComicName() {
		return this.addComicName;
	}
	
	public StringProperty getAddComicNumber() {
		return this.addComicNumber;
	}
	
	public void addComic() {
		ComicBook comic = new ComicBook(this.addComicName.get(), this.getAddComicNumber().get());
		this.comicBooks.add(comic);
	}
	
	public void removeComic() {
		
	}
	
	public void cancelAddComic() {
		//close window?
	}
	
	public void confirmAddComic() {
		
	}
	
	public ListProperty<ComicBook> getComicBooks() {
		return this.comicBooks;
	}
}
