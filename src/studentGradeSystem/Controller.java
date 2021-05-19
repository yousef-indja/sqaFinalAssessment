package studentGradeSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {
	Map<String, Rubric> allRubrics = new HashMap();
	Rubric rubric;
	public String createRubric(String name, ArrayList<String>criteria) {
		if(criteria.size() >9) {
			return"Maximum of 10 criteria per rubric";
		}else if(allRubrics.containsKey(name)){
			return"This rubric already exists";
		}else {
			rubric = new Rubric(name, criteria);
			allRubrics.put(rubric.getName(),rubric);
			return "Rubric created";
		}
	}
	
	public String addCriterion(String rubricName, String criterion) {
		boolean found = false;
		for (Map.Entry<String, Rubric> entry : allRubrics.entrySet()) {
		    String key = entry.getKey();
		    Rubric r = entry.getValue();
		    if(key.equals(rubricName)) {
		    	if(r.getCriteria() == null) {
					ArrayList<String> criteria = new ArrayList();
					criteria.add(criterion);
					r.setCriteria(criteria);
				}else {
					r.addCriteria(criterion);
				}
				found = true;
		    }
		}
		if(found == true) {
			return "added";
		}else{
			return "not added";
		}
	}
	
	public String getRubricList() {
		String results = "";
		for (Map.Entry<String, Rubric> entry : allRubrics.entrySet()) {
		    String key = entry.getKey();
		    Rubric r = entry.getValue();
		    results += r.getName() + "\n";
		}
		if(results.equals("")) {
			results = "No rubrics added";
		}
		
		return results;
		
	}

}
