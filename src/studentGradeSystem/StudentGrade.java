package studentGradeSystem;

import java.util.ArrayList;
import java.util.Map;

public class StudentGrade {

	private String studentName;
	private ArrayList<Rubric> rubric;
	public StudentGrade() {
		super();
	}
	public StudentGrade(String studentName, ArrayList<Rubric> rubric) {
		super();
		this.studentName = studentName;
		this.rubric = rubric;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public ArrayList<Rubric> getRubric() {
		return rubric;
	}
	public void setRubric(ArrayList<Rubric> rubric) {
		this.rubric = rubric;
	}
	public String toString() {
		String s = "Student: " + this.studentName;
		for(Rubric r: this.rubric) {
			s += "\nRubric: " + this.rubric.toString();
		}
		return s;
	}
}
