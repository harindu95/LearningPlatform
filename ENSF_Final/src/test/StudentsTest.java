package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import backend.Students;
import shared.Student;

public class StudentsTest {

	@Test
	public void testConstructorMapSizeEqualsZero(){
		Students s = new Students();
		assertEquals(s.students.values().size(),0);
	}
	
	@Test
	public void testGetIDCreatesAStudent() {
		Students s = new Students();
		Student student = s.getStudent(1);
		assertEquals(s.students.values().size(),1);
	}
	
	@Test
	public void testAddStudent() {
		Students s = new Students();
		Student student = new Student(30);
		s.addStudent(student);
		assertEquals(s.students.values().size(),1);
	}
	
}
