package shared;

public class Request {
	
	public enum Type {
		PUT,
		GET
	};
	
	public enum DataType {
		Student,
		StudentList,
		Professor,
		Assignment,
		Course,
		CourseList
	};
	
	public Type type = Type.GET;
	public DataType dataType ;
	public int id = 0;
	String keyword = "";
	Object data = null;
	
}
