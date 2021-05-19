package studentGradeSystem;

import java.util.ArrayList;
import java.util.Map;

public class Rubric {

	private String name;
	private Map<String, Integer>criteria;

	public Rubric() {
		super();
	}

	public Rubric(String name, Map<String, Integer> criteria) {
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

	
	public Map<String, Integer> getCriteria() {
		return criteria;
	}

	public void setCriteria(Map<String, Integer> criteria) {
		this.criteria = criteria;
	}

	public void addCriteria(String criterion) {
		this.criteria.put(criterion, null);
	}
	
	public boolean updateCriteria(String criterion, int score) {
		boolean found = false;
		for (Map.Entry<String, Integer> entry : criteria.entrySet()) {
			String key = entry.getKey();
		    if(key.equalsIgnoreCase(criterion)) {
		    	entry.setValue(score);
		    	found = true;
		    }
		}
		return found;
	}
	
	public String toString(){
		String s = this.name + "\nCriteria: ";
		for (Map.Entry<String, Integer> entry : this.criteria.entrySet()) {
		    String key = entry.getKey();
		    int r = entry.getValue();
		    s += key + ", ";
		}
		return s;
	}
}
