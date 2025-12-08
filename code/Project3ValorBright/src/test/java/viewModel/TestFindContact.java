package viewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;

class TestFindContact {

	@Test
	void testFindByNumber() {
		MainWindowViewModel  vm = new MainWindowViewModel();
		vm.getName().set("name");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		vm.getSearchCriteria().set("1234567");
		String contact = vm.findContact();
		
		assertTrue(contact.equals("name, 1234567"));
	}
	
	
	@Test
	void testFindByName() {
		MainWindowViewModel  vm = new MainWindowViewModel();
		vm.getName().set("name");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		vm.getSearchCriteria().set("name");
		String contact = vm.findContact();
		
		assertTrue(contact.equals("name, 1234567"));
	}
	
	@Test
	void testIncorrectInfo() {
		MainWindowViewModel  vm = new MainWindowViewModel();
		vm.getName().set("name");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		vm.getSearchCriteria().set("1234568");
		String contact = vm.findContact();
		
		assertFalse(contact.equals("name, 1234567"));
	}

}
