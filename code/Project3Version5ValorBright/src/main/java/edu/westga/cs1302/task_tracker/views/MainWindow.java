package edu.westga.cs1302.task_tracker.views;

import java.io.IOException;

import edu.westga.cs1302.task_tracker.Main;
import edu.westga.cs1302.task_tracker.model.Collections;
import edu.westga.cs1302.task_tracker.model.ComicBook;
import edu.westga.cs1302.task_tracker.viewmodel.AddComicWindowViewModel;
import edu.westga.cs1302.task_tracker.viewmodel.MainWindowViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

/**View for the Collection of Comics
 * 
 * @author Valor Bright
 * @version Fall 2025
 */

public class MainWindow {
    @FXML private ListView<Collections> collection;
    @FXML private ListView<ComicBook> comicBooks;
    @FXML private TextField name;
    @FXML private Button addCollection;
    @FXML private Button removeCollection;
    @FXML private Button addComic;
    @FXML private Button removeComic;
    @FXML private Button findComic;
    @FXML private MenuItem removeComicContextMenu;
  
    private MainWindowViewModel vm;
    private AddComicWindowViewModel acvm;
   
    @FXML
    void initialize() {
    	this.vm = new MainWindowViewModel();
    	this.acvm = new AddComicWindowViewModel();
    	this.vm.getName().bindBidirectional(this.name.textProperty());
    	this.collection.setItems(this.vm.getCollections());
    	this.comicBooks.setItems(this.acvm.getComicBooks());
    	
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
    	this.addComic.setOnAction(
				(event) -> {
					try {
						FXMLLoader loader = new FXMLLoader();
						loader.setLocation(Main.class.getResource(Main.OPTIONS_WINDOW_RESOURCE));
						loader.load();
				    	Parent parent = loader.getRoot();
				    	Scene scene = new Scene(parent);
				    	Stage addComicWindow = new Stage();
				    	addComicWindow.setTitle("");
				    	addComicWindow.setScene(scene);
				    	addComicWindow.initModality(Modality.APPLICATION_MODAL);
				    	addComicWindow.show();
				    	this.acvm.getCollectionNeeded(this.collection.getSelectionModel().getSelectedItem());
				    	
					} catch (IllegalArgumentException error) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setContentText("Unable to Add Comic book: " + error.getMessage());
						alert.showAndWait();
					} catch (IOException error) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setContentText("Unable to Add Comic book: " + error.getMessage());
						alert.showAndWait();
					}
				}	
			);
    	 	
    }
}

