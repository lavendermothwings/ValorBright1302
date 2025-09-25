package edu.westga.cs1302.ValorBrightProject1.views;

import edu.westga.cs1302.ValorBrightProject1.model.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	private Button submit;


	@FXML
	void addTask(ActionEvent event) {
		String name = this.name.getText();
		String priority = this.priority.getSelectionModel().getSelectedItem();
		String description = this.description.getText();

		Task newTask = new Task(name, priority, description);
		
		list.getItems().add(newTask);
		

	}

	/**
	 * Perform any needed initialization of UI components and underlying objects.
	 */
	public void initialize() {
		priority.setItems(FXCollections.observableArrayList("High", "Medium", "Low"));

	}
}
