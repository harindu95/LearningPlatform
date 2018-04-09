package shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Assignment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4334556365362330749L;
	private int id = 0;
	private boolean active = true;
	private String title = "";
//	private String path = "";
	private String due_date  = "";
	private FileObj file = null;
	private Course course = null;
	private List<Submission> submissions;
	
	public Assignment(int id){
		this.setId(id);
		setSubmissions(new ArrayList<Submission>());
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
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

	/**
	 * @return the due_date
	 */
	public String getDue_date() {
		return due_date;
	}

	/**
	 * @param due_date the due_date to set
	 */
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the file
	 */
	public FileObj getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(FileObj file) {
		this.file = file;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
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

	public void addSubmission(Submission s) {
		// TODO Auto-generated method stub
		submissions.add(s);
	}
}

