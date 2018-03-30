package shared;

import java.io.Serializable;

public class Assignment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4334556365362330749L;
	private int id = 0;
	private boolean active = true;
	private String title = "";
	private String path = "";
	private String due_date  = "";
	
	public Assignment(int id){
		this.setId(id);
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
}

