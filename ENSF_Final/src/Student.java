import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends User{
	List<Submission> submissions;
	List<Course> courses;
	List<Grade> grades;
	
	Student(int id){
		super(id);
		courses = new ArrayList<>();
		submissions = new ArrayList<>();
		grades = new ArrayList<>();
	}
}
