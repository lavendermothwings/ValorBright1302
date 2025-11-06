package edu.westga.cs1302.main_window_view_model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import viewmodel.MainWindowViewModel;

class TestGenerateAPassword {
/*
 * test less than 1, 1, and 2, 3
 * test false and true
 */
	
	@Test
	void testLengthOfOne() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		viewModel.minimumLengthProperty().set(10);
		viewModel.getDigitProperty().set(true);
		String password = viewModel.generateAPassword();
	
		assertTrue(10 <= password.length(), "checking length of generated password");
	}
	
	@Test
	void testMinLengthOneAllUnChecked() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		viewModel.minimumLengthProperty().set(1);
		viewModel.getDigitProperty().set(false);
		viewModel.getLowerProperty().set(false);
		viewModel.getUpperProperty().set(false);
		String password = viewModel.generateAPassword();
	
		assertTrue(1 <= password.length(), "checking length of generated password");
	}
	
	@Test
	void testMinLengthTwoAllUnChecked() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		viewModel.minimumLengthProperty().set(2);
		viewModel.getDigitProperty().set(false);
		viewModel.getLowerProperty().set(false);
		viewModel.getUpperProperty().set(false);
		String password = viewModel.generateAPassword();
	
		assertTrue(2 <= password.length(), "checking length of generated password");
	}
	
	@Test
	void testMinLengthThreeAllUnChecked() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		viewModel.minimumLengthProperty().set(3);
		viewModel.getDigitProperty().set(false);
		viewModel.getLowerProperty().set(false);
		viewModel.getUpperProperty().set(false);
		String password = viewModel.generateAPassword();
	
		assertTrue(3 <= password.length(), "checking length of generated password");
	}
	
	@Test
	void testMinimumLength1AtLeastOneUpperCaseLetterNoOtherRestriction() {
		MainWindowViewModel viewModel = new MainWindowViewModel();
		viewModel.minimumLengthProperty().set(1);
		viewModel.getDigitProperty().set(true);
		viewModel.getLowerProperty().set(false);
		viewModel.getUpperProperty().set(false);
		String password = viewModel.generateAPassword();
		String digit = "\\d{1}";
		for (int iterate = 0; iterate < password.length(); iterate++) {
			Character currChar = password.charAt(iterate);
		}

		assertTrue(password.matches("\\d{1,}"));
	}

}
