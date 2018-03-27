import java.util.List;

public class Student {
	int ID = 0;
	String firstName = "";
	String lastName = "";
	List<Submission> submission;
	List<Course> courses;
	
	Student(int id){
		this.ID = id;
	}
}
