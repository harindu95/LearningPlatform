package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shared.Assignment;
import shared.Submission;

public class Submissions {
	Map<Assignment,List<Submission>> submissions;
	public Submissions(){
		submissions = new HashMap<>();
	}
	
	List<Submission> getSubmissions(Assignment key){
		return submissions.get(key);
	}

	public void add(Submission s) {
		List<Submission> list= submissions.get(s.getAssignment());
		if(list == null) {
			list = new ArrayList<>();
			submissions.put(s.getAssignment(), list);
		}
		list.add(s);
	
	}


}
