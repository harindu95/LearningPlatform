import java.util.List;

public class Course {
	int ID = 0;
	String name = "";
	Professor professor;
	boolean isActive =false;
	List<Assignment> assignments;
	List<Student> students;
	
	Course(int id){
		this.ID = id;
	}
}
