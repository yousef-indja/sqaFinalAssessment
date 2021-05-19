package studentGradeSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {
	Map<String, Rubric> allRubrics = new HashMap();
	ArrayList<StudentGrade> allStudentGrades = new ArrayList();
	Rubric rubric;
	StudentGrade studentGrade;
	public String createRubric(String name, Map<String, Integer>criteria) {
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
					Map<String, Integer> criteria = new HashMap();
					criteria.put(criterion, null);
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
		    results += r.toString() + "\n \n";
		}
		if(results.equals("")) {
			results = "No rubrics added";
		}
		
		return results;
		
	}
	
	public String getRubricByName(String name) {
		String results = "";
		for (Map.Entry<String, Rubric> entry : allRubrics.entrySet()) {
		    String key = entry.getKey();
		    Rubric r = entry.getValue();
		    if(key.equals(name)) {
		    	results += r.toString() + "\n \n";
		    }
		    
		}
		if(results.equals("")) {
			results = "No rubrics added";
		}
		
		return results;
	}
	
	public boolean createNewStudentGrade(String studentName, String rubricName ) {
		boolean found = false;
		for (Map.Entry<String, Rubric> entry : allRubrics.entrySet()) {
			String key = entry.getKey();
		    Rubric r = entry.getValue();
		    if(r.getName().equals(rubricName)) {
		    	ArrayList rubrics = new ArrayList();
		    	rubrics.add(r);
		    	studentGrade = new StudentGrade(studentName, rubrics);
		    	allStudentGrades.add(studentGrade);
		    	found = true;
		    }
		}
		return found;
		
	}
	
	public boolean addScoreToGrade(String rubricName, String studentName, String criterion, int score) {
		boolean completed = false;
		if(score<=5) {
			for(StudentGrade sg: allStudentGrades) {
				if(sg.getStudentName().equals(studentName)) {
					for (Map.Entry<String, Rubric> entry : allRubrics.entrySet()) {
						String key = entry.getKey();
					    Rubric rbrc = entry.getValue();				   
					    if(key.equalsIgnoreCase(rubricName)) {			
					    	boolean added = rbrc.updateCriteria(criterion, score);
					    	if (added == true) {
					    		completed = true;
					    	}
					    }
					}
				}
			}
		}
		
		return completed;
	}

}
