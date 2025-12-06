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
public class Exam3PrepViewModel {
	private StringProperty name;
	private ListProperty<Student> students;
	private ListProperty<Integer> gpaOptions;
	private IntegerProperty selectedGpa;
	
	public Exam3PrepViewModel(){
		this.name = new SimpleStringProperty("");
		this.students = new SimpleListProperty<Student>(FXCollections.observableArrayList(new ArrayList<Student>()));
		this.gpaOptions = new SimpleListProperty<Integer>(FXCollections.observableArrayList(new ArrayList<Integer>()));
		this.selectedGpa = new SimpleIntegerProperty(4);
		this.gpaOptions.add(1);//initialize items in combobox
    	this.gpaOptions.add(2);
    	this.gpaOptions.add(3);
    	this.gpaOptions.add(4);
    	this.selectedGpa = new SimpleIntegerProperty(4);
	}

	public StringProperty getName() {
		return name;
	}

	public ListProperty<Student> getStudents() {
		return students;
	}

	public ListProperty<Integer> getGpaOptions() {
		return gpaOptions;
	}

	public IntegerProperty getSelectedGpa() {
		return selectedGpa;
	}
	
	public void addStudent() {
		Student student = new Student(this.name.get(), this.selectedGpa.get());
		this.students.add(student); //practice adding student
	}
	
	
	
}
