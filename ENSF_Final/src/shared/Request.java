package shared;

import java.io.Serializable;

public class Request implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5538508514328378144L;
	public enum Type {
		UPDATE,
		GET,
		DELETE
	};
	
	public enum DataType {
		Student,
		StudentList,
		Professor,
		Assignment,
		Course,
		CourseList,
		Login,
		ENROLL,
		UNROLL,
		
	};
	
	public Type type = Type.GET;
	public DataType dataType ;
	public int id = 0;
	
	public String userID = "";
	public String userPassword = "";
	public String keyword = "";
	public boolean isValid = false;
	public Object data = null;
	
}
