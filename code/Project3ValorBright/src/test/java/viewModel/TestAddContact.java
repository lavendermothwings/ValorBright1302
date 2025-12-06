package viewModel;

import static org.junit.jupiter.api.Assertions.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collections.model.Contact;
import edu.westga.cs1302.comic_collections.viewmodel.MainWindowViewModel;

class TestAddContact {

	@Test
	void testAddSameNameAndPhoneNumber() {
		MainWindowViewModel  vm = new MainWindowViewModel();
		vm.getName().set("name");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		vm.getName().set("name");
		vm.getPhoneNumber().set("1234567");
		assertThrows(IllegalArgumentException.class, ()  -> {vm.addContact();});
		
	}
	
	@Test
	void testAddSameName() {
		MainWindowViewModel  vm = new MainWindowViewModel();
		vm.getName().set("name");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		vm.getName().set("name");
		vm.getPhoneNumber().set("1234568");
		assertThrows(IllegalArgumentException.class, ()  -> {vm.addContact();});
	}
	
	@Test
	void testAddSameNumber() {
		MainWindowViewModel  vm = new MainWindowViewModel();
		vm.getName().set("name");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		vm.getName().set("nametw0");
		vm.getPhoneNumber().set("1234567");
		assertThrows(IllegalArgumentException.class, ()  -> {vm.addContact();});
	}
	
	
}

	

