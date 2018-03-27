import java.util.List;
import java.util.Map;

public class Professors {
	Map<Integer, Professor> professors;

	public Professor getProfessor(int id) {
		Professor s = professors.get(id);
		if (s == null) {
			professors.put(id, new Professor(id));
		}
		return s;
	}

}