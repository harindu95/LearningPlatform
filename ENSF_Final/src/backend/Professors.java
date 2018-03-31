package backend;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shared.Professor;
import shared.User;

public class Professors {
	private Map<Integer, Professor> professors;
	DatabaseManager db;
	
	public Professors() {
		setProfessors(new HashMap<>());
	}

	public Professor getProfessor(int id) {
		Professor p = getProfessors().get(id);
		if (p == null) {
			p = new Professor(id);
			getProfessors().put(id, p);
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

	/**
	 * @return the professors
	 */
	public Map<Integer, Professor> getProfessors() {
		return professors;
	}

	/**
	 * @param professors the professors to set
	 */
	public void setProfessors(Map<Integer, Professor> professors) {
		this.professors = professors;
	}

}