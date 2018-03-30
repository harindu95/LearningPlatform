package shared;

import java.io.Serializable;

public class Grade implements Serializable{

	private static final long serialVersionUID = -1171934780244060694L;
	private Assignment assignment;
	private int grade;
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
}
