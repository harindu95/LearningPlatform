import java.util.ArrayList;
import java.util.List;

public class Student extends User{
	List<Submission> submissions;
	List<Course> courses;
	
	Student(int id){
		super(id);
		courses = new ArrayList<>();
		submissions = new ArrayList<>();
	}
}
