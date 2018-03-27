import java.util.ArrayList;
import java.util.List;

public class Professor {
	int ID = 0;
	String name = "";
	List<Course> courses;
	
	Professor(int id, String name){
		this.ID = id;
		this.name = name;
		courses = new ArrayList<>();
	}
	
	Professor(int id){
		this.ID = id;
		this.name = name;
		courses = new ArrayList<>();
	}
}
