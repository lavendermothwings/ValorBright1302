package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestSaveStudentData {

	@Test
	void testNoStudents()throws IllegalArgumentException, IOException {
		StudentDataPersistenceManager.saveStudentData(new Student[0], "test-data-empty.txt");
		
		File inputFile = new File("test-data-empty.txt");
		try(Scanner reader = new Scanner(inputFile)){
		assertFalse(reader.hasNextLine(), "checking if file is empty(should have no lines)");
		}
		
		
	}
	
	@Test
	void testSaveOneStudent()throws IllegalArgumentException, IOException{
		Student student1 = new Student("wren", 5);
		Student[] studentArray = new Student[3];
		studentArray[0] = student1;
		
		StudentDataPersistenceManager.saveStudentData(studentArray, "test-data-save-load.txt");

				File inputFile = new File("test-data-save-load.txt");
				
				try(Scanner reader = new Scanner(inputFile)){
					assertEquals(reader.nextLine(), "wren,5");	
				}
				
				
	}

	@Test
	void testSaveMultipleStudents()throws IllegalArgumentException, IOException{
		Student student1 = new Student("wren", 5);
		Student student2 = new Student("valter", 10);
		Student student3 = new Student("brehn", 15);
		Student student4 = new Student("boudica", 20);
		Student[] studentArray = new Student[4];
		studentArray[0] = student1;
		studentArray[1] = student2;
		studentArray[2] = student3;
		studentArray[3] = student4;
		
		StudentDataPersistenceManager.saveStudentData(studentArray, "test-data-save-load.txt");

				File inputFile = new File("test-data-save-load.txt");
				
				try(Scanner reader = new Scanner(inputFile)){
					assertEquals(reader.nextLine(), "wren,5");
					assertEquals(reader.nextLine(), "valter,10");
					assertEquals(reader.nextLine(), "brehn,15");
					assertEquals(reader.nextLine(), "boudica,20");
					
				}
				
				
				try(Scanner reader = new Scanner(inputFile)){
					assertTrue(reader.hasNextLine(), "checking if file has one line");
					
			}
	}
	
	
	
	
	

}
