package studentGradeSystem;

import java.util.ArrayList;

public class Rubric {

	private String name;
	private ArrayList<String>criteria;

	public Rubric() {
		super();
	}

	public Rubric(String name, ArrayList<String> criteria) {
		super();
		this.name = name;
		this.criteria = criteria;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getCriteria() {
		return criteria;
	}

	public void setCriteria(ArrayList<String> criteria) {
		this.criteria = criteria;
	}
	
	public void addCriteria(String criterion) {
		criteria.add(criterion);
	}
	
	public String toString(){
		String s = this.name + "\nCriteria: ";
		for (String string:this.criteria) {
			s += string + ", ";
		}
		return s;
	}
}
