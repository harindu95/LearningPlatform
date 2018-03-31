package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import backend.Professors;
import backend.Students;
import shared.Student;
import shared.User;

public class ProfessorsTest {

	@Test
	public void testConstructorMapSizeEqualsZero(){
		Professors s = new Professors();
		assertEquals(s.getProfessors().values().size(),0);
	}
	
	@Test
	public void testGetIDCreatesAProfessors() {
		Professors s = new Professors();
		s.getProfessor(1);
		assertEquals(s.getProfessors().values().size(),1);
	}
	
	@Test
	public void testAddProfessor() {
		Professors s = new Professors();
		s.addProfessor(new User(23));
		assertEquals(s.getProfessors().values().size(),1);
	}
	
}
