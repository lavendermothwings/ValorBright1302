package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestCheckIfNewValueIsZero {

	@Test
	void testIfAcceptsZero() {
		ViewModel vm = new ViewModel();
		String newValue = "0";
		
		assertFalse(vm.checkIfNewValueIsZero(newValue));
	}
	
	@Test
	void testIfAcceptsOne() {
		ViewModel vm = new ViewModel();
		String newValue = "1";
		
		assertTrue(vm.checkIfNewValueIsZero(newValue));
	}


}
