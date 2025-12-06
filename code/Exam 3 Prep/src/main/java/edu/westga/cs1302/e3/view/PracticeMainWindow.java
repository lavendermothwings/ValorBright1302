package edu.westga.cs1302.e3.view;

import edu.westga.cs1302.e3.model.Student;
import edu.westga.cs1302.e3.viewmodel.Exam3PrepViewModel;
import javafx.beans.property.ListProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class PracticeMainWindow {
    @FXML private TextField nameTextField;
    @FXML private ListView<Student> studentsListView;
    @FXML private ComboBox<Integer> gpaComboBox;
    @FXML private Button addStudentButton;
    @FXML private Button displayDetailsButton;
	
	private Exam3PrepViewModel vm; 

    @FXML
    void initialize() {
    	this.vm = new Exam3PrepViewModel();// initialize model
    	
    	this.nameTextField.textProperty().bindBidirectional(this.vm.getName());
    	this.studentsListView.setItems(this.vm.getStudents());
    	this.gpaComboBox.setItems(this.vm.getGpaOptions());
    	
    	this.vm.getSelectedGpa().bind(this.gpaComboBox.getSelectionModel().selectedItemProperty());// cannot be bidirectional
    	
    	this.addStudentButton.setOnAction((event) ->{
    		try {
    		this.vm.addStudent();
    		} catch (IllegalArgumentException error) {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setContentText(error.getMessage());
    			alert.showAndWait();
    		}
    	});
    
    }
	
}
