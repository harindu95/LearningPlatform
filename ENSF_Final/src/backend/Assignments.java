package backend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shared.Assignment;

public class Assignments {
	Map<Integer, Assignment> assignments;
	DatabaseManager db;
	
	public Assignments() {
		assignments = new HashMap<>();
	}

	public Assignment getAssignment(int id) {
		Assignment a = assignments.get(id);
		if (a == null) {
			a = new Assignment(id);
			assignments.put(id,a);
		}
		return a;
	}
	
	public void setDBManager(DatabaseManager mgr) {
		this.db = mgr;
	}

	public void addAssignment(Assignment data) {
		db.updateAssignment(data);
		db.readData();
	}

	public void removeAssignment(Assignment data) {
		// TODO Auto-generated method stub
		db.removeAssignment(data);
		db.readData();
	}
	
	

}
