package studentGradeSystem;

import java.util.ArrayList;

public class Rubric {

	private ArrayList<String>criteria;

	public Rubric() {
		super();
	}

	public Rubric(ArrayList<String> criteria) {
		super();
		this.criteria = criteria;
	}

	public ArrayList<String> getCriteria() {
		return criteria;
	}

	public void setCriteria(ArrayList<String> criteria) {
		this.criteria = criteria;
	}
	
	
}
