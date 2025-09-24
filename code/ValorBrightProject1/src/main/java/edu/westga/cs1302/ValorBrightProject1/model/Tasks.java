package edu.westga.cs1302.ValorBrightProject1.model;

import java.awt.TextArea;
import java.awt.TextField;

import javafx.scene.control.ComboBox;

public class Tasks {

	private TextField name;
	private TextArea description;
	private ComboBox<String> priority;
	
	//make name and priority final
	//toString that returns name of tasks
	
	public Tasks(TextField name, TextArea description, ComboBox<String> priority) {
		this.name = name;
		this.description = description;
		this.priority = priority;
	}
	
	public TextField getName() {
		return this.name;
	}
	
	public TextArea getDescription() {
		return this.description;
	}
	
	public ComboBox<String> getPriority() {
		return this.priority;
	}
	
	public void setName(TextField name) {
		this.name = name;
	}
	
	
	
	
	
	
}
