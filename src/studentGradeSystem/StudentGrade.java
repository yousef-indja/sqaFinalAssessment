package studentGradeSystem;

import java.util.ArrayList;
import java.util.Map;

public class StudentGrade {

	private String studentName, rubric;
	private Map<String, Integer>criteria;
	private int total;
	public StudentGrade() {
		super();
	}
	
	
	public StudentGrade(String studentName, String rubric, Map<String, Integer> criteria, int total) {
		super();
		this.studentName = studentName;
		this.rubric = rubric;
		this.criteria = criteria;
		this.total = total;
	}
	

	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getRubric() {
		return rubric;
	}


	public void setRubric(String rubric) {
		this.rubric = rubric;
	}


	public Map<String, Integer> getCriteria() {
		return criteria;
	}


	public void setCriteria(Map<String, Integer> criteria) {
		this.criteria = criteria;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public String toString() {
		String s = "Student: " + this.studentName + "\nRubrics: " +this.rubric
		+ "\nGrade: " + this.getTotal();
		
		return s;
	}
}
