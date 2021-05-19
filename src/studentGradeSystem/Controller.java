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
		rubric = new Rubric();
		if(rubric.getCriteria() == null) {
			ArrayList<String> criteria = new ArrayList();
			criteria.add(criterion);
			rubric.setCriteria(criteria);
		}else {
			rubric.addCriteria(criterion);
		}
		return rubric.getCriteria().get(0);
	}

}
