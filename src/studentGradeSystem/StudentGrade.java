package studentGradeSystem;

import java.util.Map;

public class StudentGrade {

	private String studentName;
	private Rubric rubric;
	public StudentGrade() {
		super();
	}
	public StudentGrade(String studentName, Rubric rubric) {
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
	public Rubric getRubric() {
		return rubric;
	}
	public void setRubric(Rubric rubric) {
		this.rubric = rubric;
	}
	
	public String toString() {
		return "Student: " + this.studentName + "\nRubric: " + this.rubric.toString();
	}
}
