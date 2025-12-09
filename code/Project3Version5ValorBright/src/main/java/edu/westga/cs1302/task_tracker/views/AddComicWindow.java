package edu.westga.cs1302.task_tracker.views;

import edu.westga.cs1302.task_tracker.viewmodel.AddComicWindowViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

/** Controller for AddComicWindow
 * @author Valor Bright
 * @version Fall 2025
 */
public class AddComicWindow {
 
    @FXML private TextField addComicName;
    @FXML private TextField addComicNumber;
    @FXML private Button cancelAddComic;
    @FXML private Button confirmAddComic;

    private AddComicWindowViewModel acvm;
   
    @FXML
    void initialize() {
    	this.acvm = new AddComicWindowViewModel();
    	
    	this.acvm.getAddComicName().bindBidirectional(this.addComicName.textProperty());
    	this.acvm.getAddComicNumber().bindBidirectional(this.addComicNumber.textProperty());
    	
    	this.cancelAddComic.setOnAction(
				(event) -> {
					try {
						this.acvm.removeComic();
					} catch (IllegalArgumentException error) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setContentText("Unable to Remove Comic book: " + error.getMessage());
						alert.showAndWait();
					}
				}
			); 
    	
    	this.confirmAddComic.setOnAction(
				(event) -> {
					try {
						this.acvm.confirmAddComic();
					//	this.vm.getComicBooks();
			
					} catch (IllegalArgumentException error) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setContentText("Unable to Add Comic book: " + error.getMessage());
						alert.showAndWait();
					}
				}
			);	
    }
   
}

