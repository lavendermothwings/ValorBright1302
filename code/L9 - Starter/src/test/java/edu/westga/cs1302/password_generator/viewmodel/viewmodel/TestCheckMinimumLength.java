package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestCheckMinimumLength {

	@Test
	void testWithLetter() {
		ViewModel vm = new ViewModel();
		
		assertTrue(vm.checkMinimumLength("a"));
	}

	
	@Test
	void testWithNumber() {
		ViewModel vm = new ViewModel();
		
		assertFalse(vm.checkMinimumLength("1"));
	}
	
	@Test
	void testWithBlank() {
		ViewModel vm = new ViewModel();
		
		assertTrue(vm.checkMinimumLength(" "));
	}
	
	@Test
	void testWithZero() {
		ViewModel vm = new ViewModel();
		
		assertTrue(vm.checkMinimumLength("0"));
	}
	
	@Test
	void testWithEmpty() {
		ViewModel vm = new ViewModel();
		
		assertTrue(vm.checkMinimumLength(""));
	}
}
