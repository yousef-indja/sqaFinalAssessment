package studentGradeSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class ControllerTest {

	private Rubric rubric;
	
	private Controller controller;
	@BeforeEach
	public void setUp()throws Exception{
		controller = new Controller();
		rubric = new Rubric();
	}
	
	@Test
	@DisplayName("Creating correct rubric should work")
	public void createRubricTest() {
		Map criteria = new HashMap();
		criteria.put("addition", null);
		criteria.put("subtraction", null);
		assertEquals("Rubric created", controller.createRubric("Maths", criteria),
				 "Rubric was not created"); 
	}
	
	@Test
	@DisplayName("Creating rubric with too many criterion should not work")
	public void createRubricWithTooManyCriterionTest() {
		Map test = new HashMap();
		test.put("addition", null);
		test.put("subtraction", null);
		test.put("multiplication", null);
		test.put("division", null);
		test.put("percentages", null);
		test.put("algebra", null);
		test.put("calculus", null);
		test.put("constants", null);
		test.put("equations", null);
		test.put("functions", null);
		test.put("geometry", null);
		assertEquals("Maximum of 10 criteria per rubric", controller.createRubric("Maths", test),
				 "Rubric should not have been created"); 
	}
	
	@Test
	@DisplayName("Creating a rubric that already exists should not work")
	public void createExistingRubricTest() {
		Map test = new HashMap();
		controller.createRubric("Maths", test);
		Map criteria = new HashMap();
		criteria.put("addition", null);
		criteria.put("subtraction", null);
		assertEquals("This rubric already exists", controller.createRubric("Maths", criteria),
				 "Rubric should not have been created"); 
	}
	
	@Test
	@DisplayName("Adding criterion to existing rubric should work")
	public void addCriterionTest() {
		Map test = new HashMap();
		controller.createRubric("java", test);
		assertEquals("added", controller.addCriterion("java", "comments"),
				 "Criteria was not added to rubric"); 
	}
	
	@Test
	@DisplayName("Adding criterion to non existing rubric should not work")
	public void addCriterionToNonExistingRubricTest() {
		assertEquals("not added", controller.addCriterion("java", "comments"),
				 "Criteria shouldnt have been added to rubric"); 
	}
	
	@Test
	@DisplayName("Display rubrics should work")
	public void getRubricListTest() {
		assertEquals("No rubrics added" , controller.getRubricList(),
				 "Adding criteria to a rubric should work"); 
		Map test = new HashMap();
		controller.createRubric("python", test);
		controller.createRubric("java", test);
		assertEquals("python\nCriteria: \n \njava\nCriteria: \n \n" , controller.getRubricList(),
				 "List of rubrics should be displayed"); 
		
	}
	
	@Test
	@DisplayName("Display specific rubric should work")
	public void getRubricByNameTest() {
		assertEquals("No rubrics added" , controller.getRubricList(),
				 "Adding criteria to a rubric should work"); 
		Map test = new HashMap();
		controller.createRubric("python", test);
		controller.createRubric("java", test);
		assertEquals("python\nCriteria: \n \n" , controller.getRubricByName("python"),
				 "List of rubrics should be displayed"); 
		assertEquals("java\nCriteria: \n \n" , controller.getRubricByName("java"),
				 "List of rubrics should be displayed"); 
		
	}
	
	
	@Test
	@DisplayName("Creating a student grade should work")
	public void createStudentGradeTest() {
		Map test = new HashMap();
		controller.createRubric("python", test);
		assertEquals(true , controller.createNewStudentGrade("Aaron", "python"),
				 "StudentGrade should be created"); 
		
	}
	
	@Test
	@DisplayName("Creating a student grade for non existing rubric should not work")
	public void createStudentGradeForNonexistingRubricTest() {
		assertEquals(false , controller.createNewStudentGrade("Aaron", "python"),
				 "StudentGrade should be created"); 
		
	}
	
	@Test
	@DisplayName("Ading a score to a criterion should work")
	public void addScoreToGradeTest() {
		Map test = new HashMap();
		test.put("design", null);
		controller.createRubric("python", test);
		controller.createNewStudentGrade("Aaron", "python");
		assertEquals(true , controller.addScoreToGrade("python", "Aaron", "design", 3),
				 "Criterion grade should be updated"); 
		
	}
	
	@Test
	@DisplayName("Adding a score above 5 to a criterion should not work")
	public void addScoreAbove5ToGradeTest() {
		Map test = new HashMap();
		test.put("design", null);
		controller.createRubric("python", test);
		controller.createNewStudentGrade("Aaron", "python");
		assertEquals(false , controller.addScoreToGrade("python", "Aaron", "design", 6),
				 "Criterion grade should not be updated"); 
		
	}
	
	@Test
	@DisplayName("Adding a score a criterion that doesnt exist should not work")
	public void addScoreToNonExistingCriterionTest() {
		Map test = new HashMap();
		test.put("design", null);
		controller.createRubric("python", test);
		controller.createNewStudentGrade("Aaron", "python");
		assertEquals(false , controller.addScoreToGrade("python", "Aaron", "implementation", 3),
				 "Criterion grade should not be updated"); 
		
	}
	
	@Test
	@DisplayName("Adding a score a rubric that doesnt exist should not work")
	public void addScoreToNonExistingRubricTest() {
		Map test = new HashMap();
		test.put("design", null);
		controller.createRubric("python", test);
		controller.createNewStudentGrade("Aaron", "python");
		assertEquals(false , controller.addScoreToGrade("java", "Aaron", "design", 3),
				 "Criterion grade should not be updated"); 
		
	}
	
	@Test
	@DisplayName("Adding a score a student that doesnt exist should not work")
	public void addScoreToNonExistingStudentTest() {
		Map test = new HashMap();
		test.put("design", null);
		controller.createRubric("python", test);
		controller.createNewStudentGrade("Aaron", "python");
		assertEquals(false , controller.addScoreToGrade("python", "Jamie", "design", 3),
				 "Criterion grade should not be updated"); 
		
	}
	
	
	
	
	
	

}
