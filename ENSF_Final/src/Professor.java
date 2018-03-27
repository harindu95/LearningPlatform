import java.util.ArrayList;
import java.util.List;

public class Professor {
	int ID = 0;
	String firstName = "";
	String lastName = "";
	List<Course> courses;
	
	Professor(int id, String name){
		this.ID = id;
		this.lastName = name;
		courses = new ArrayList<>();
	}
	
	Professor(int id){
		this.ID = id;
		courses = new ArrayList<>();
	}
}
