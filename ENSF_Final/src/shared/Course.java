package shared;
import java.util.ArrayList;
import java.util.List;

public class Course {
	int ID = 0;
	String name = "";
	public Professor professor;
	public boolean isActive =false;
	public List<Assignment> assignments;
	public List<Student> students;
	
	public Course(int id){
		this.ID = id;
		students = new ArrayList<>();
		assignments = new ArrayList<>();
	}
}
