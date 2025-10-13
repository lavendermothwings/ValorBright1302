package edu.westga.cs1302.Project1ValorBright2025.views;

import java.util.ArrayList;
import java.util.Collections;

import edu.westga.cs1302.Project1ValorBright2025.model.Ascending;
import edu.westga.cs1302.Project1ValorBright2025.model.CountPriority;
import edu.westga.cs1302.Project1ValorBright2025.model.Descending;
import edu.westga.cs1302.Project1ValorBright2025.model.Task;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	
	@FXML
    private TextArea description;

    @FXML
    private ListView<Task> list = new ListView<Task>();

    @FXML
    private TextField name;

    @FXML
	private ComboBox<String> priority = new ComboBox<String>();
    @FXML
    private ComboBox<String> sortList = new ComboBox<String>();

    @FXML
    private TextArea selectedDisplay;

    @FXML
    private TextField selectedPriority;
    
    @FXML
    private TextField lowTotal;

    @FXML
    private TextField mediumTotal;
    
    @FXML
    private TextField highTotal;
    
    @FXML 
    private ComboBox<String> countPriority = new ComboBox<String>();

    @FXML
    void addTask(ActionEvent event) throws IllegalArgumentException {
    	try {
    	String name = this.name.getText();
		String priority = this.priority.getSelectionModel().getSelectedItem();
		String description = this.description.getText();

		Task newTask = new Task(name, description, priority);
		
		this.list.getItems().add(newTask);
    } catch (IllegalArgumentException error) {
    	Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText("Did not provide enough information. Please check the name of the task, description, or priority.");
		alert.showAndWait();
    }
    }

    @FXML
    void countPriority(ActionEvent event) {
    	
    	CountPriority countHigh = new CountPriority();
    	CountPriority countMedium = new CountPriority();
    	CountPriority countLow = new CountPriority();
    	ArrayList<Task> task = new ArrayList<Task>();
    	int highTotal = 0;
    	int mediumTotal = 0;
    	int lowTotal = 0;
    	
    	for (int iterate = 0; iterate < this.list.getItems().size(); iterate++) {
    		task.add(iterate, this.list.getItems().get(iterate));
    	}
    	
    	
    	highTotal = countHigh.getCount("High", task);
    	mediumTotal = countMedium.getCount("Medium", task);
    	lowTotal = countLow.getCount("Low", task);
    	
    	this.highTotal.setText(String.valueOf(highTotal));
    	this.mediumTotal.setText(String.valueOf(mediumTotal));
    	this.lowTotal.setText(String.valueOf(lowTotal));
   
    }

    @FXML
    void removeTask(ActionEvent event) throws IndexOutOfBoundsException {
    	try {
    		int numTask = this.list.getSelectionModel().getSelectedIndex();
		this.list.getItems().remove(numTask);
		
		 if (this.list.getItems().isEmpty()) {
			this.selectedDisplay.clear();
			this.selectedPriority.clear();
			this.lowTotal.clear();
			this.mediumTotal.clear();
			this.highTotal.clear();
		}
		} catch (IndexOutOfBoundsException error) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("No task to remove");
			alert.showAndWait();
		}

    }

    @FXML
    void updateDescription(ActionEvent event) throws IllegalArgumentException, NullPointerException {
    	try {
    	if (this.selectedDisplay.getText() == null) {
			throw new IllegalArgumentException("no description provided");
		}
		if (this.selectedDisplay.getText().isEmpty() || this.selectedDisplay.getText().isBlank()) {
			throw new IllegalArgumentException("no description provided");
		}
		
		this.list.getSelectionModel().getSelectedItem().setDescription(this.selectedDisplay.getText());
    	} catch (IllegalArgumentException error) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Description update cannot be blank or empty");
			alert.showAndWait();
    		
    	} catch (NullPointerException error) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("No task is selected. Please select or add task.");
			alert.showAndWait();
    	}
		
	}
    
    @FXML
    void sortByPriority(ActionEvent event) {
    	String sortPriority = this.sortList.getSelectionModel().getSelectedItem();
    	Ascending ascend = new Ascending();
    	Descending descend = new Descending();
    	if (sortPriority.equals("Ascending")) {
    		this.list.getItems().sort(ascend);
    	}
    	else if (sortPriority.equals("Descending")) {
    		this.list.getItems().sort(descend);
    	}

    }
    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	this.priority.setItems(FXCollections.observableArrayList("High", "Medium", "Low"));
    	this.sortList.setItems(FXCollections.observableArrayList("Ascending", "Descending"));
    	
   
    	this.list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Task>() {
    	
			@Override
			public void changed(ObservableValue<? extends Task> observable, Task oldValue, Task newValue) {	
				if (MainWindow.this.list.getItems().isEmpty()) {
					//This prevents an error when tasks are removed
					MainWindow.this.list.getItems().isEmpty();
				} else if (!newValue.equals(oldValue)) {
					MainWindow.this.selectedDisplay.setText(newValue.getDescription());
					MainWindow.this.selectedPriority.setText(newValue.getPriority());
				 }
				
			}
			
		});
    	
    	this.countPriority.setItems(FXCollections.observableArrayList("High", "Medium", "Low"));
    	
    }
}
