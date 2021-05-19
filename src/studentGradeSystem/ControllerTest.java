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
				 "creating rubric should work"); 
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
				 "Creating rubric with too many criterion should not work"); 
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
				 "creating rubric should work"); 
	}
	
	@Test
	@DisplayName("Adding criterion to a rubric should work")
	public void addCriterionTest() {
		rubric = new Rubric();
		assertEquals("comments", controller.addCriterion("java", "comments"),
				 "Adding criteria to a rubric should work"); 
	}
	
	

}
