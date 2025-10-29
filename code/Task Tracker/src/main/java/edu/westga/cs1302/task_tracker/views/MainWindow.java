package edu.westga.cs1302.task_tracker.views;

import java.util.Comparator;

import edu.westga.cs1302.task_tracker.model.AscendingByName;
import edu.westga.cs1302.task_tracker.model.AscendingByPriority;
import edu.westga.cs1302.task_tracker.model.DescendingByName;
import edu.westga.cs1302.task_tracker.model.DescendingByPriority;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;
import edu.westga.cs1302.task_tracker.model.TaskUtility;
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
    @FXML private ComboBox<Comparator<Task>> order;
    @FXML private ListView<Task> subTasks;

    /** Add a new task with the provided information to the listview.
     * 
     * @precondition none
     * @postcondition A task will be added to the listview with 
     * 							  1) a name matching the text of the name textfield, 
     * 							  2) a description matching the text of the description textarea,
     * 							  3) a priority matching the selected value of the priority combobox,
     * 
     * @param event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML 
    void addTask(ActionEvent event) {
    	try {
    		this.tasks.getItems().add(new Task(this.name.getText(), this.description.getText(), this.priority.getValue()));
    		this.sortLists();
    		
    	} catch (IllegalArgumentException error) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText(error.getMessage());
    		alert.showAndWait();
    	}
    }

    /** Display the priority and description of the task selected in the listview.
     * 
     * @precondition none
     * @postcondition the description for the selected task will be displayed in the selectedDescription text area &&
     * 				  the priority for the selected task will be displayed in the selectedPriority text field
     * 
     * @param event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML
    void selectTask(MouseEvent event) {
    	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
    	this.subTasks.getItems().clear();
    	if (selectedTask != null) {
    		this.selectedPriority.setText(selectedTask.getPriority().toString());
    		this.selectedDescription.setText(selectedTask.getDescription());
    		for (int iterate = 0; iterate < selectedTask.getSubTasks().size(); iterate++) {
    			this.subTasks.getItems().add(selectedTask.getSubTasks().get(iterate));
    		}
    		
    	}
    }

    /** Remove the currently selected task.
     * 
     * @precondition none
     * @postcondition task selected in the listview will be removed
     * 
     * @param event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML
    void removeTask(ActionEvent event) {
    	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
    	if (selectedTask != null) {
    		this.tasks.getItems().remove(selectedTask);
    	}
    	this.sortLists();
    	
    }

    /** Update the description of the selected task.
     * 
     * @precondition none
     * @postcondition description for the task selected in the listview will be updated to match the text in the selectedDescription text area.
     * 
     * @param event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML
    void updateDescription(ActionEvent event) {
    	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
    	if (selectedTask != null) {
    		selectedTask.setDescription(this.selectedDescription.getText());
    	}
    }

    /** Display the count of tasks for each priority.
     * 
     * @precondition none
     * @postcondition count of tasks for each priority are displayed in the appropriate labels.
     * 
     * @param event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML
    void countPriorities(ActionEvent event) {
    	this.highCount.setText(Integer.toString(TaskUtility.countOfPriority(TaskPriority.HIGH, this.tasks.getItems())));
    	this.mediumCount.setText(Integer.toString(TaskUtility.countOfPriority(TaskPriority.MEDIUM, this.tasks.getItems())));
    	this.lowCount.setText(Integer.toString(TaskUtility.countOfPriority(TaskPriority.LOW, this.tasks.getItems())));
    }
    
    /** Sort tasks based on the selected ordering.
     * 
     * @precondition none
     * @postcondition tasks in the listview are sorted based on the provided ordering.
     * 
     * @param event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML
    void sortTasks(ActionEvent event) {
    	this.sortLists();
    }
    
    /* Sort the listView for tasks
     * 
     * @precondition none
     * @postcondition tasks in the listview are sorted based on the provided ordering
     */
    private void sortLists() {
    	if (this.order.getValue() != null) {
    		this.tasks.getItems().sort(this.order.getValue());
    	}
    }
   
    /** Adds a subTask to the task
     * 
     * @precondition none
     * @postcondition	A subTask will be added to the selected Task with 
     * 					1) a name matching the text of the name of the selectedTask, 
     * 					2) a description matching the text of the description textarea,
     * 					3) a priority matching the selected value of the priority combobox,
     * 					4) Task will be replaced with Task with a new name to indicated subTask have been added
     * 
     * @param  event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML
    void addSubTask(ActionEvent event) {
    	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();

    	try {
    		Task subTask = new Task(this.name.getText(), this.description.getText(), this.priority.getValue()); 
    	
    	Task replaceTask = selectedTask.addTask(subTask);
    	
    	this.tasks.getItems().remove(selectedTask);
    	this.tasks.getItems().add(replaceTask);
    } catch (NullPointerException error) {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setContentText("Select a Task to add Subtask");
		alert.showAndWait();
    	
    }
    
    }
    
    /** Pops up an alert window to show the details of a task
     * 
     * @precondition selectedTask != null
     * @postcondition Displays a pop up alert with information about selected subTask
     * 
     * @param event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML
    void popUpSubTask(MouseEvent event) {
    	Task selectedTask = this.subTasks.getSelectionModel().getSelectedItem();
    	try {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setContentText("Name: " + selectedTask + System.lineSeparator() + "Description: " + selectedTask.getDescription() + System.lineSeparator() + "Priority: " + selectedTask.getPriority());
		alert.showAndWait();
    	} catch (NullPointerException error) {
	    	Alert alert = new Alert(AlertType.ERROR);
	    	alert.setContentText("Select a Task to see subTask");
			alert.showAndWait();
    	}
    }
    
    
    /** Perform any needed initialization of UI components and underlying objects.
     * 
     * @precondition none
     * @postcondition none
     * 
     */
    @FXML
    public void initialize() {
    	this.priority.getItems().addAll(TaskPriority.HIGH, TaskPriority.MEDIUM, TaskPriority.LOW);
    	this.priority.setValue(this.priority.getItems().get(0));
    	this.order.getItems().add(new AscendingByPriority());
    	this.order.getItems().add(new DescendingByPriority());
    	this.order.getItems().add(new AscendingByName());
    	this.order.getItems().add(new DescendingByName());
    	this.priority.setValue(this.priority.getItems().get(0));
    }
}
