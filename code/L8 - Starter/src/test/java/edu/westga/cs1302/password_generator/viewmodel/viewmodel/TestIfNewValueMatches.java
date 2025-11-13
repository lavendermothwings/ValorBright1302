package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestIfNewValueMatches {

	@Test
	void testIfAcceptsLetter() {
		ViewModel vm = new ViewModel();
		String newValue = "h";
		
		assertTrue(vm.checkIfNewValueMatches(newValue));
	}
	
	@Test
	void testIfAcceptsDigit() {
		ViewModel vm = new ViewModel();
		String newValue = "1";
		
		assertFalse(vm.checkIfNewValueMatches(newValue));
	}
	
	@Test
	void testIfAcceptsOtherCharacters() {
		ViewModel vm = new ViewModel();
		String newValue = "/";
		
		assertTrue(vm.checkIfNewValueMatches(newValue));
	}

	@Test
	void testIfAcceptsOtherLettersAndNumbers() {
		ViewModel vm = new ViewModel();
		String newValue = "h1";
		
		assertTrue(vm.checkIfNewValueMatches(newValue));
	}
	
	@Test
	void testIfAcceptsNegative() {
		ViewModel vm = new ViewModel();
		String newValue = "-1";
		
		assertTrue(vm.checkIfNewValueMatches(newValue));
	}

}
