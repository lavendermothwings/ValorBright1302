package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestLoadStudentData {

	@Test
	void testNoStudents()throws IllegalArgumentException, IOException {
		
		StudentDataPersistenceManager.saveStudentData(new Student[0], "test-data-empty.txt");
		Student[] testLoad = StudentDataPersistenceManager.loadStudentData("test-data-empty.txt");
		
		assertEquals(testLoad.length, 0);
	}
	
	@Test
	void testLoadOneStudent()throws IllegalArgumentException, IOException {
		Student student1 = new Student("boudica", 5);
		Student[] studentArray = new Student[1];
		studentArray[0] = student1;
		StudentDataPersistenceManager.saveStudentData(studentArray, "test-data-save-load.txt");	
		Student[] testLoad = StudentDataPersistenceManager.loadStudentData("test-data-save-load.txt");
		assertEquals(testLoad[0].getName(), "boudica");
		assertEquals(testLoad[0].getGrade(), 5);
	}
	
	@Test
	void testLoadMultipleStudents()throws IllegalArgumentException, IOException {
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
		Student[] testLoad = StudentDataPersistenceManager.loadStudentData("test-data-save-load.txt");
		
		assertEquals(testLoad[0].getName(), "wren");
		assertEquals(testLoad[0].getGrade(), 5);
		assertEquals(testLoad[1].getName(), "valter");
		assertEquals(testLoad[1].getGrade(), 10);
		assertEquals(testLoad[2].getName(), "brehn");
		assertEquals(testLoad[2].getGrade(), 15);
		assertEquals(testLoad[3].getName(), "boudica");
		assertEquals(testLoad[3].getGrade(), 20);
		
}
	
	@Test
	void testLoadWithBadData()throws IllegalArgumentException, IOException {
		assertThrows(IOException.class, ()->{StudentDataPersistenceManager.loadStudentData("test-bad-data.txt");});
		
	}
	
}




