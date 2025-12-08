package edu.westga.cs1302.task_tracker.views;

import edu.westga.cs1302.task_tracker.model.Collections;
import edu.westga.cs1302.task_tracker.model.ComicBook;
import edu.westga.cs1302.task_tracker.viewmodel.AddComicWindowViewModel;
import edu.westga.cs1302.task_tracker.viewmodel.MainWindowViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class MainWindow {
    @FXML private ListView<Collections> collection;
    @FXML private ListView<ComicBook> comicBooks;
    @FXML private TextField name;
    @FXML private Button addCollection;
    @FXML private Button removeCollection;
    @FXML private Button addComic;
    @FXML private Button removeComic;
    @FXML private MenuItem removeComicContextMenu;
  
    private MainWindowViewModel vm;
    
    
    
    
    
    
    @FXML
    void initialize() {
    	this.vm = new MainWindowViewModel();
    	
    	this.vm.getName().bindBidirectional(this.name.textProperty());
    	this.collection.setItems(this.vm.getCollections());
 //   	this.comicBooks.setItems(this.vm.getComicBooks());
//    	this.acvm.getAddComicName().bindBidirectional(this.addComicName.textProperty());
//    	this.acvm.getAddComicNumber().bindBidirectional(this.addComicNumber.textProperty());
    	
    	
    	
    	this.addCollection.setOnAction(
				(event) -> {
					try {
						this.vm.addCollection();
					} catch (IllegalArgumentException error) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setContentText("Unable to Add Collection: " + error.getMessage());
						alert.showAndWait();
					}
				}
			);
    	
    	
    	this.removeCollection.setOnAction(
				(event) -> {
					try {
						Collections selectedCollection;
						selectedCollection = this.collection.getSelectionModel().getSelectedItem();
						this.collection.getItems().remove(selectedCollection);
					} catch (IllegalArgumentException error) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setContentText("Unable to Remove Collection: " + error.getMessage());
						alert.showAndWait();
					}
				}
			);
//    	
//    	this.addComic.setOnAction(
//				(event) -> {
//					try {
//						this.vm.addComic();
//					} catch (IllegalArgumentException error) {
//						Alert alert = new Alert(AlertType.ERROR);
//						alert.setContentText("Unable to Add Comic book: " + error.getMessage());
//						alert.showAndWait();
//					}
//				}
//			);
//    	
//    	
//    	this.removeComic.setOnAction(
//				(event) -> {
//					try {
//						this.vm.removeComic();
//					} catch (IllegalArgumentException error) {
//						Alert alert = new Alert(AlertType.ERROR);
//						alert.setContentText("Unable to Remove Comic book: " + error.getMessage());
//						alert.showAndWait();
//					}
//				}
//			);
    	
//    	this.cancelAddComic.setOnAction(
//				(event) -> {
//					try {
//						this.vm.removeComic();
//					} catch (IllegalArgumentException error) {
//						Alert alert = new Alert(AlertType.ERROR);
//						alert.setContentText("Unable to Remove Comic book: " + error.getMessage());
//						alert.showAndWait();
//					}
//				}
//			);
//    	
//    	this.cancelAddComic.setOnAction(
//				(event) -> {
//					try {
//						
//					} catch (IllegalArgumentException error) {
//						Alert alert = new Alert(AlertType.ERROR);
//						alert.setContentText("Unable to Remove Comic book: " + error.getMessage());
//						alert.showAndWait();
//					}
//				}
//			);
//    	
//    	this.confirmAddComic.setOnAction(
//				(event) -> {
//					try {
//						
//					} catch (IllegalArgumentException error) {
//						Alert alert = new Alert(AlertType.ERROR);
//						alert.setContentText("Unable to Remove Comic book: " + error.getMessage());
//						alert.showAndWait();
//					}
//				}
//			);
    	
    	
    }
   
}

