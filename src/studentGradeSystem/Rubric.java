package studentGradeSystem;
import java.util.ArrayList;
import java.util.Map;

public class Rubric {

	private String name;
	private Map<String, Integer>criteria;
	private int total;

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
	
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	public String toString(){
		String s = this.name + "\nCriteria: ";
		for (Map.Entry<String, Integer> entry : this.criteria.entrySet()) {
		    String key = entry.getKey();
		    int r = entry.getValue();
		    s += key + ": " + r + ", ";
		}
		return s;
	}
}
