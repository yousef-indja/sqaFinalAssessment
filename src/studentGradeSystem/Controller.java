package studentGradeSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Controller {
	ArrayList<Rubric> allRubrics = new ArrayList();
	ArrayList<StudentGrade> allStudentGrades = new ArrayList();
	
	public Controller() {
		/*createRubric("Python");
		createRubric("Java");
		addCriterion("Python", "documentation");
		addCriterion("Python", "design");
		addCriterion("Python", "implementation");
		addCriterion("Python", "testing");
		addCriterion("Java", "documentation");
		addCriterion("Java", "design");
		addCriterion("Java", "implementation");
		addCriterion("Java", "testing");
		listAllRubrics();
		createGrade("Aarron", "Python");
		createGrade("Owen", "Python");
		createGrade("Jamie", "Java");
		addScoreToCriterion("Aarron", "Python", "Design", 3);
		addScoreToCriterion("Aarron", "Python", "Documentation", 5);
		addScoreToCriterion("Owen", "Python", "Design", 4);
		addScoreToCriterion("Jamie", "Java", "Implementation", 2);
		allGradesForRubric("python");
		rubricSummaryAverage("python");
		rubricSummaryStandardDeviation("python");
		rubricSummaryMaxMin("python");
		criterionSummaryAverage("python", "design");
		criterionSummaryStandardDeviation("python", "design");
		criterionSummaryMaxMin("python", "design");*/
	}
	
	public boolean createRubric(String rubricName) {
		boolean created = false;
		boolean duplicate = false;
		boolean incorrect = false;
		for(Rubric r: allRubrics) {
			if(r.getName().equalsIgnoreCase(rubricName)) {
				duplicate = true;
			}
		}
		if(rubricName.equals("")||rubricName == null) {
			incorrect = true;
			
		}
		if(duplicate == false && incorrect == false) {
			Map<String, Integer> criteria = new HashMap();
			Rubric r = new Rubric(rubricName, criteria);
			allRubrics.add(r);
			created = true;
		}
		return created;
	}
	
	public boolean addCriterion(String rubricName, String criterion) {
		boolean added = false;
		for(Rubric r: allRubrics) {
			if(r.getName().equalsIgnoreCase(rubricName)) {
				Map<String, Integer> newCriteria = r.getCriteria();
				if(newCriteria.size()<=9) {
					newCriteria.put(criterion, 0);
					r.setCriteria(newCriteria);
					added = true;
				}
				//System.out.println(r.toString());
			}
		}
		return added;
	}
	
	public String listAllRubrics() {
		String listRubrics= "";
		for(Rubric r: allRubrics) {
			listRubrics += r.toString() + "\n";
		}
		
		if(listRubrics.equals("")) {
			listRubrics = "No Rubrics Added.";
		}
		return listRubrics;
	}
	
	public String showRubricByName(String rubricName) {
		String listRubrics= "";
		for(Rubric r: allRubrics) {
			if(r.getName().equalsIgnoreCase(rubricName)) {
				listRubrics += r.toString();
			}
			
		}
		
		if(listRubrics.equals("")) {
			listRubrics = "No Matching Rubric Found.";
		}
		return listRubrics;
	}
	
	public boolean createGrade(String studentName, String rubricName) {
		boolean created = false;
		ArrayList<Rubric> rubrics = new ArrayList();
		Map<String, Integer> criteria = new HashMap();
		int total = 0;
		for(Rubric r: allRubrics) {
			if(r.getName().equalsIgnoreCase(rubricName)) {
				for (Map.Entry<String, Integer> entry : r.getCriteria().entrySet()) {
					String key = entry.getKey();
					int value = entry.getValue();
					criteria.put(key, 0);
					total += value;
				}
				StudentGrade sg = new StudentGrade(studentName, rubricName, criteria, total);
				allStudentGrades.add(sg);
				created = true;
				//System.out.println(sg.toString());
			}
			
		}
		return created;
		
	}
	
	public boolean addScoreToCriterion(String student, String rubric, String criterion, int score) {
		boolean added = false;
		if(score<=5) {
			for(StudentGrade sg: allStudentGrades) {
				if(sg.getStudentName().equalsIgnoreCase(student)) {
					if(sg.getRubric().equalsIgnoreCase(rubric)) {
						for (Map.Entry<String, Integer> entry : sg.getCriteria().entrySet()) {
						    String key = entry.getKey();
						    int value = entry.getValue();
						    if(key.equalsIgnoreCase(criterion)) {
						    	entry.setValue(score);
						    	int total = sg.getTotal();
							    total = total + score;
							    sg.setTotal(total);
							    added = true;
						    }
						    
						    	
						}
					}
				}
			}
		}
		
		return added;
	}
	
	public String allGradesForRubric(String rubric) {
		String grades = "";
		int score = 0;
		for(StudentGrade sg: allStudentGrades) {
			if(sg.getRubric().equalsIgnoreCase(rubric)) {
				grades += sg.getStudentName() + ": " + sg.getTotal() + "\n";
				//System.out.println(sg.getStudentName() + sg.getTotal());
			}
			
		}
		if(grades.equals("")) {
			grades = "No grades found for that rubric.";
		}
		return grades;
	}
	
	public double rubricSummaryAverage(String rubric) {
		double total = 0;
		double amount= 0;
		double average=0;
		for(StudentGrade sg: allStudentGrades) {
			if(sg.getRubric().equalsIgnoreCase(rubric)) {
				amount ++;
				total += sg.getTotal();
			}
		}
		
		
		if(amount != 0) {
			average = total/amount;
		}
			//System.out.println(average);
		
		
		return average;
	}
	
	public double rubricSummaryStandardDeviation(String rubric) {
		ArrayList<Integer> score = new ArrayList();
		for(StudentGrade sg: allStudentGrades) {
			if(sg.getRubric().equalsIgnoreCase(rubric)) {
				score.add(sg.getTotal());
			}
		}
		
	    double mean = rubricSummaryAverage(rubric);
	    double temp = 0;

	    for (int i = 0; i < score.size(); i++)
	    {
	        int val = score.get(i);
	        double squrDiffToMean = Math.pow(val - mean, 2);
	        temp += squrDiffToMean;
	    }
	    double meanOfDiffs = (double) temp / (double) (score.size());
	    //System.out.println(Math.sqrt(meanOfDiffs));
	    return Math.sqrt(meanOfDiffs);
		
	}
	
	public String rubricSummaryMaxMin(String rubric) {
		ArrayList<Integer> score = new ArrayList();
		for(StudentGrade sg: allStudentGrades) {
			if(sg.getRubric().equalsIgnoreCase(rubric)) {
				score.add(sg.getTotal());
			}
		}
		return("Max: " + Collections.max(score) + "\nMin: " + Collections.min(score));

	}
	
	public double criterionSummaryAverage(String rubric, String criterion){
		double total = 0;
		double amount= 0;
		double average=0;
		
		for(StudentGrade sg: allStudentGrades) {
			if(sg.getRubric().equalsIgnoreCase(rubric)) {
				for (Map.Entry<String, Integer> entry : sg.getCriteria().entrySet()) {
				    String key = entry.getKey();
				    int value = entry.getValue();
				    if(key.equalsIgnoreCase(criterion)) {
				    	amount ++;
						total += value;
				    }
				}
				
			}
		}
		
		if(amount != 0) {
			average = total/amount;
		}
		
		//System.out.println(average);
		
		
		//System.out.println("Criterion" + average);
		return average;
	}
	
	public double criterionSummaryStandardDeviation(String rubric, String criterion) {
		ArrayList<Integer> score = new ArrayList();
		for(StudentGrade sg: allStudentGrades) {
			if(sg.getRubric().equalsIgnoreCase(rubric)) {
				for (Map.Entry<String, Integer> entry : sg.getCriteria().entrySet()) {
				    String key = entry.getKey();
				    int value = entry.getValue();
				    if(key.equalsIgnoreCase(criterion)) {
				    	score.add(value);
				    }
				}
				
			}
		}
		
	    double mean = criterionSummaryAverage(rubric, criterion);
	    double temp = 0;

	    for (int i = 0; i < score.size(); i++)
	    {
	        int val = score.get(i);
	        double squrDiffToMean = Math.pow(val - mean, 2);
	        temp += squrDiffToMean;
	    }
	    double meanOfDiffs = (double) temp / (double) (score.size());
	    //System.out.println(Math.sqrt(meanOfDiffs));
	    return Math.sqrt(meanOfDiffs);
		
	}
	
	public String criterionSummaryMaxMin(String rubric, String criterion) {
		ArrayList<Integer> score = new ArrayList();
		for(StudentGrade sg: allStudentGrades) {
			if(sg.getRubric().equalsIgnoreCase(rubric)) {
				for (Map.Entry<String, Integer> entry : sg.getCriteria().entrySet()) {
				    String key = entry.getKey();
				    int value = entry.getValue();
				    if(key.equalsIgnoreCase(criterion)) {
				    	score.add(value);
				    }
				}
			}
		}
		
		return("Max: " + Collections.max(score) + "\nMin: " + Collections.min(score));

	}
	
	

	/*public static void main(String[] args) {
		new Controller();
	}*/

}
