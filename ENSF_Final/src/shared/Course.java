package shared;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable{
	
	private static final long serialVersionUID = -3665685309899493952L;
	private int id = 0;
	private String name = "";
	private Professor professor;
	private boolean isActive =false;
	public List<Assignment> assignments;
	private List<Student> students;
	
	public Course(int id){
		this.id = id;
		setStudents(new ArrayList<>());
		assignments = new ArrayList<>();
	}

	/**
	 * @return the professor
	 */
	public Professor getProfessor() {
		return professor;
	}

	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
