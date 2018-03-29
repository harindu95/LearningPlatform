package shared;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends User{
	public List<Submission> submissions;
	public List<Course> courses;
	public List<Grade> grades;
	
	public Student(int id){
		super(id);
		courses = new ArrayList<>();
		submissions = new ArrayList<>();
		grades = new ArrayList<>();
	}
}
