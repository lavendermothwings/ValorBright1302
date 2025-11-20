package edu.westga.cs1302.password_generator.view;

import javafx.scene.control.MenuItem;

import java.io.IOException;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.Node;

import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 * Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

	@FXML
	private CheckBox mustIncludeDigits;
	@FXML
	private CheckBox mustIncludeLowerCaseLetters;
	@FXML
	private CheckBox mustIncludeUpperCaseLetters;
	@FXML
	private TextField minimumLength;
	@FXML
	private Label errorTextLabel;
	@FXML
	private Label minLengthErrorText;
	@FXML
	private Button generatePasswordButton;
	@FXML
	private ListView<String> passwordHistory;
	@FXML
	private MenuItem chooseFile;
	@FXML
	private AnchorPane guiPane;
	@FXML
	private TextArea output;

	@FXML
	private MenuItem about;
	@FXML
	private MenuItem close;
	@FXML
	private MenuItem save;

	private ViewModel vm;
	
	@FXML
	void initialize() {

		this.vm = new ViewModel();
		this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
		this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
		this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
		this.minimumLength.setText(this.vm.getMinimumLength().getValue());
		this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
		

		this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
		this.passwordHistory.setItems(this.vm.getPasswordHistory());
		
		this.minimumLength.textProperty().addListener((observable, newValue, oldValue) -> {
			Boolean cube = this.vm.checkMinimumLength(newValue);
			this.generatePasswordButton.setDisable(false);
	
			this.minLengthErrorText.setVisible(this.vm.checkMinimumLength(newValue)); 
			
			if (cube.equals(true)) {
				this.generatePasswordButton.disableProperty().set(true);					
			} 
				
		});
	
		
		this.generatePasswordButton.setOnAction((event) -> {
			this.vm.generatePassword();
		});

		this.save.setOnAction((event) -> {
			
			this.vm.chooseAFile();
			try {
				this.vm.savePassword();
			} catch (IOException error) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Did not access file or save properly");
			alert.showAndWait();
			}

		});
		
		this.about.setOnAction((event) -> {
			this.vm.openAbout();
		});
		
		this.close.setOnAction((event) -> {
			((Node) (this.errorTextLabel)).getScene().getWindow().hide();
		});
	}


	
	

}