package studentGradeSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

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
		ArrayList criteria = new ArrayList();
		criteria.add("addition");
		criteria.add("subtraction");
		assertEquals("Rubric created", controller.createRubric("Maths", criteria),
				 "Rubric was not created"); 
	}
	
	@Test
	@DisplayName("Creating rubric with too many criterion should not work")
	public void createRubricWithTooManyCriterionTest() {
		ArrayList criteria = new ArrayList();
		String[] criterion = {"addition", "subtraction", "multiplication", "division",
				"percentages", "algebra", "calculus", "constants", "equations", 
				"functions", "geometry"};
		criteria.addAll(Arrays.asList(criterion));
		assertEquals("Maximum of 10 criteria per rubric", controller.createRubric("Maths", criteria),
				 "Rubric should not have been created"); 
	}
	
	@Test
	@DisplayName("Creating a rubric that already exists should not work")
	public void createExistingRubricTest() {
		ArrayList test = new ArrayList();
		controller.createRubric("Maths", test);
		ArrayList criteria = new ArrayList();
		criteria.add("addition");
		criteria.add("subtraction");
		assertEquals("This rubric already exists", controller.createRubric("Maths", criteria),
				 "Rubric should not have been created"); 
	}
	
	@Test
	@DisplayName("Adding criterion to existing rubric should work")
	public void addCriterionTest() {
		ArrayList test = new ArrayList();
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
		ArrayList test = new ArrayList();
		controller.createRubric("python", test);
		controller.createRubric("java", test);
		controller.createRubric("javascript", test);
		assertEquals("python\njava\njavascript\n" , controller.getRubricList(),
				 "List of rubrics should be displayed"); 
		
	}
	
	
	

}
