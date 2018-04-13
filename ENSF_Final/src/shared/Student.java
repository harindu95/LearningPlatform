package shared;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4174262105288358852L;
	private List<Submission> submissions;
	private List<Course> courses;
	private List<Grade> grades;
	
	public Student(int id){
		super(id);
		setCourses(new ArrayList<>());
		setSubmissions(new ArrayList<>());
		setGrades(new ArrayList<>());
	}

	/**
	 * @return the grades
	 */
	public List<Grade> getGrades() {
		return grades;
	}
	
	
	public int getGrade(int assign_id) {
		for(Grade g: grades) {
			if(g.getAssignment().getId() == assign_id) {
				return g.getGrade();
			}
		}
		return 0;
	}

	/**
	 * @param grades the grades to set
	 */
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	/**
	 * @return the submissions
	 */
	public List<Submission> getSubmissions() {
		return submissions;
	}

	/**
	 * @param submissions the submissions to set
	 */
	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}

	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
