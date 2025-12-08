package edu.westga.cs1302.contact_manager.view;

import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

/** Codebehind for the MainWindow
 * 
 * @author Valor Bright
 * @version Fall 2025
 */
public class MainWindow {
	@FXML private Button addCollection;
    @FXML private TextField name;
    @FXML private AnchorPane guiPane;
	
	
	
	private MainWindowViewModel vm;
	
	@FXML
	void initialize() {
		assert this.addCollection != null : "fx:id=\"addContact\" was not injected: check your FXML file 'MainWindow.fxml'.";
		
		this.vm = new MainWindowViewModel();
		
		this.vm.getName().bind(this.name.textProperty());
		
		 this.addCollection.setOnAction(
					(event) -> {
						try {
							this.vm.addContact();
						} catch (IllegalArgumentException error) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setContentText("Unable to Add Colecction: " + error.getMessage());
							alert.showAndWait();
						}
					}
				);
	
	}
}
