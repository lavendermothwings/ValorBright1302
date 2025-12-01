package viewModel;

import static org.junit.jupiter.api.Assertions.*;
import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.model.Contact;

class TestAddContact {

	@Test
	void test() {
		Contact contact = new Contact("name", "1234567");
		MainWindowViewModel  vm = new MainWindowViewModel();
		vm.addContact();
		vm.getPhoneNumber().get();
		System.out.println(vm.getPhoneNumber().toString());
	}

}
