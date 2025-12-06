package edu.westga.cs1302.e3.viewmodel;

import java.util.ArrayList;

import edu.westga.cs1302.e3.model.Student;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/** Implements behavior for the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */

public class BookStore {
private StringProperty title;
private ListProperty<Student> bookOwners;
private ListProperty<Integer> ratingOptions;
private IntegerProperty selectedRatings;


public BookStore() {
this.title = new SimpleStringProperty("");
this.bookOwners = new SimpleListProperty<Student>(FXCollections.observableArrayList(new ArrayList<Student>()));
this.ratingOptions = new SimpleListProperty<Integer>(FXCollections.observableArrayList(new ArrayList<Integer>()));
this.selectedRatings = new SimpleIntegerProperty(4);
this.ratingOptions.add(1);
this.ratingOptions.add(2);
this.ratingOptions.add(3);
this.ratingOptions.add(4);
}


public StringProperty getTitle() {
	return title;
}


public ListProperty<Student> getBookOwners() {
	return bookOwners;
}


public ListProperty<Integer> getRatingOptions() {
	return ratingOptions;
}


public IntegerProperty getSelectedRatings() {
	return selectedRatings;
}

public void addBookOwner() {
	Student bookOwner = new Student(this.title.get(), this.selectedRatings.get());
	this.bookOwners.add(bookOwner);
}
}
