package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private TextArea output;
    @FXML private Label errorTextLabel;
    @FXML private Button generatePasswordButton;
    @FXML private ListView<String> listOfPasswords;
    
    private ViewModel vm;

    @FXML
    void initialize() {
    	this.vm = new ViewModel();
    	this.bindProperties();
    	this.bindBehavior();
    	this.setupListenersForValidation();
    }
    
    private void bindBehavior() {
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    			try {
    				this.vm.generatePassword();
    			} catch (IllegalArgumentException error) {
    				Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setContentText(error.getMessage());
					alert.showAndWait();
    			}
    					
    			}
    	);	
    
    }
    
    private void bindProperties() {
    	this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
    	this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
    	this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
    	this.minimumLength.setText(this.vm.getMinimumLength().getValue());
    	this.vm.getMinimumLength().bind(this.minimumLength.textProperty()); 	
 
    	this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
    	this.listOfPasswords.setItems(this.vm.getPastPasswords());
    }
    
    private void setupListenersForValidation() {
		this.minimumLength.textProperty().addListener((observable, oldValue, newValue) -> {
				this.errorTextLabel.setVisible(this.vm.checkMinimumLengthText(newValue));
		});

	}
    
}
