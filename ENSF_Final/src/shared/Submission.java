package shared;
import java.util.List;

public class Submission {
	private Assignment assignment;
	private String title ="";
	String comments = "";
	private String timeStamp = "";
	private int submission_grade;
	private String path = "";
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the submission_grade
	 */
	public int getSubmission_grade() {
		return submission_grade;
	}
	/**
	 * @param submission_grade the submission_grade to set
	 */
	public void setSubmission_grade(int submission_grade) {
		this.submission_grade = submission_grade;
	}
}
