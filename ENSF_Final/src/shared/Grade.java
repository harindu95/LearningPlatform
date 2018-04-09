package shared;

import java.io.Serializable;

public class Grade implements Serializable{

	private static final long serialVersionUID = -1171934780244060694L;
	private Assignment assignment;
	private int grade;
	private int id;
	
	public Grade(int id) {
		this.setId(id);
	}
	/**
	 * @return the assignment
	 */
	public Assignment getAssignment() {
		return assignment;
	}
	/**
	 * @param assignment the assignment to set
	 */
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
