package edu.westga.cs1302.password_generator.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import viewmodel.MainWindowViewModel;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private TextArea output;
  
    private MainWindowViewModel viewModel = new MainWindowViewModel();

    /** Generates a new password
     * 
     * @param event not used just here for checkstyle
     */
    @FXML
    void generatePassword(ActionEvent event) {
    	int minimumLength = -1;
    	
    	try {
    		minimumLength = Integer.parseInt(this.minimumLength.getText());
    	} catch (NumberFormatException numberError) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Invalid Minimum Length: must be a positive integer, but was " + this.minimumLength.getText());
    		alert.show();
    		return;
    	}
    	
    	try {
    		//this.generator.setMinimumLength(minimumLength);
    		this.viewModel.whatIsTheLength(minimumLength);
    	} catch (IllegalArgumentException invalidLengthError) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Invalid Minimum Length: " + invalidLengthError.getMessage());
    		alert.show();
    		return;
    	}
    	
    	this.viewModel.isDigitChecked(this.mustIncludeDigits.isSelected());
    	this.viewModel.isLowerCaseChecked(this.mustIncludeLowerCaseLetters.isSelected());
    	this.viewModel.isUpperCaseChecked(this.mustIncludeUpperCaseLetters.isSelected());
    	String password = this.viewModel.generateAPassword();
    	
    	this.output.setText(password);
    }    

    @FXML
    void initialize() {
        assert this.mustIncludeDigits != null : "fx:id=\"mustIncludeDigits\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.mustIncludeLowerCaseLetters != null : "fx:id=\"mustIncludeLowerCaseLetters\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.mustIncludeUpperCaseLetters != null : "fx:id=\"mustIncludeUpperCaseLetters\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.minimumLength != null : "fx:id=\"minimumLength\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.output != null : "fx:id=\"output\" was not injected: check your FXML file 'MainWindow.fxml'.";

        this.minimumLength.setText("1");
        this.bindComponentsToViewModel();
    }
/**Binds the components to viewmodel
 *   
 */
    
public void bindComponentsToViewModel() {
	this.minimumLength.textProperty().bindBidirectional(this.viewModel.minimumLengthProperty(), new NumberStringConverter());
	this.viewModel.getDigitProperty().bind(this.mustIncludeDigits.selectedProperty());
	this.viewModel.getLowerProperty().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
	this.viewModel.getUpperProperty().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
	
    }

}
