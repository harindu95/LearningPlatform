package backend;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shared.Professor;
import shared.User;

public class Professors {
	Map<Integer, Professor> professors;
	DatabaseManager db;
	
	public Professors() {
		professors = new HashMap<>();
	}

	public Professor getProfessor(int id) {
		Professor p = professors.get(id);
		if (p == null) {
			p = new Professor(id);
			professors.put(id, p);
		}
		return p;
	}
	
	public void setDBManager(DatabaseManager mgr) {
		this.db = mgr;
	}
	
	public void addProfessor(User u) {
		Professor p = getProfessor(u.id);
		p.setEmail(u.getEmail());
		p.setFirstName(u.getFirstName());
		p.setLastName(u.getLastName());
		p.setPassword(u.getPassword());
	}

}