package edu.westga.cs1302.password_generator.view;


import javafx.scene.control.MenuItem;

import java.io.File;
import java.io.IOException;

import edu.westga.cs1302.password_generator.Main;
import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class FileWindow {

    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private Label errorTextLabel;
    @FXML private Label minLengthErrorText;
    @FXML private Button generatePasswordButton;
    @FXML private ListView<String> passwordHistory;
    @FXML private MenuItem chooseFile;
    
    private ViewModel vm;
    private PasswordGenerator generator;
    
    
    @FXML
	void initialize() {
	
	}
    
    /**
	 * Set the password generator for the OptionsWindow
	 * 
	 * @precondition generator != null
	 * @postcondition password generator is set
	 * 
	 * @param generator the password generator to set when options are changed
	 */
	public void setPasswordGenerator(PasswordGenerator generator) {
		if (generator == null) {
			throw new IllegalArgumentException("generator must not be null");
		}
		this.generator = generator;
		this.minimumLength.setText(this.generator.getMinimumLength() + "");
		this.mustIncludeDigits.selectedProperty().set(this.generator.getMustHaveAtLeastOneDigit());
		this.mustIncludeLowerCaseLetters.selectedProperty().set(this.generator.getMustHaveAtLeastOneLowerCaseLetter());
		this.mustIncludeUpperCaseLetters.selectedProperty().set(this.generator.getMustHaveAtLeastOneUpperCaseLetter());
	}
    
}
