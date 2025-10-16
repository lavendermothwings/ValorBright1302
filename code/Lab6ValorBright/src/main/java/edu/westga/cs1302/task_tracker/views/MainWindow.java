package edu.westga.cs1302.task_tracker.views;

import edu.westga.cs1302.task_tracker.model.Ascending;
import edu.westga.cs1302.task_tracker.model.Descending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;
import edu.westga.cs1302.task_tracker.model.TaskUtility;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/** Controller class for MainWindow of the Task Tracker system.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
    @FXML private TextArea description;
    @FXML private Label highCount;
    @FXML private Label lowCount;
    @FXML private Label mediumCount;
    @FXML private TextField name;
    @FXML private ComboBox<TaskPriority> priority;
    @FXML private TextArea selectedDescription;
    @FXML private TextField selectedPriority;
    @FXML private ListView<Task> tasks;
    @FXML private ComboBox<String> order;
    
    @FXML 
    void addTask(ActionEvent event) {
    	try {
    		this.tasks.getItems().add(new Task(this.name.getText(), this.description.getText(), this.priority.getValue()));
    	} catch (IllegalArgumentException error) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText(error.getMessage());
    		alert.showAndWait();
    	}
    }

    @FXML
    void selectTask(MouseEvent event) {
    	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
    	if (selectedTask != null) {
    		this.selectedPriority.setText(selectedTask.getPriority().toString());
    		this.selectedDescription.setText(selectedTask.getDescription());
    	}
    }

    @FXML
    void removeTask(ActionEvent event) {
    	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
    	if (selectedTask != null) {
    		this.tasks.getItems().remove(selectedTask);
    	}
    }

    @FXML
    void updateDescription(ActionEvent event) {
    	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
    	if (selectedTask != null) {
    		selectedTask.setDescription(this.selectedDescription.getText());
    	}
    }

    @FXML
    void countPriorities(ActionEvent event) {
    	this.highCount.setText(Integer.toString(TaskUtility.countOfPriority(TaskPriority.HIGH, this.tasks.getItems())));
    	this.mediumCount.setText(Integer.toString(TaskUtility.countOfPriority(TaskPriority.MEDIUM, this.tasks.getItems())));
    	this.lowCount.setText(Integer.toString(TaskUtility.countOfPriority(TaskPriority.LOW, this.tasks.getItems())));
    }
    
    @FXML
    void sortTasks(ActionEvent event) throws IllegalArgumentException, NullPointerException {
    	String sortPriority = this.order.getSelectionModel().getSelectedItem();
    	Ascending ascend = new Ascending();
    	Descending descend = new Descending();
    	
    	try {
    		if (this.tasks.getItems().isEmpty()) {
        		throw new IllegalArgumentException("no description provided");
        	}
    	if (sortPriority.equals("Ascending")) {
    		this.tasks.getItems().sort(ascend);
    	} else if (sortPriority.equals("Descending")) {
    		this.tasks.getItems().sort(descend);
    	}
    	}  catch (IllegalArgumentException error) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("No task have been added to the list. Please add a task to the list to use this function");
			alert.showAndWait();
    	} catch (NullPointerException error) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Task cannot be null");
			alert.showAndWait();
    	}
    	
    }

    /** Perform any needed initialization of UI components and underlying objects.
     * 
     */
    public void initialize() {
    	this.priority.getItems().addAll(TaskPriority.HIGH, TaskPriority.MEDIUM, TaskPriority.LOW);
    	this.priority.setValue(this.priority.getItems().get(0));
    	this.order.setItems(FXCollections.observableArrayList("Ascending", "Descending"));
    }
}
