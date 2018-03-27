import java.util.Map;

public class Students {
	Map<Integer,Student> students;
	
	public Student getStudent(int id){
		Student s = students.get(id);
		if(s == null) {
			students.put(id, new Student(id));
		}
		return s;
	}
}
