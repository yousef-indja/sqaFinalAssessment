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
		assertEquals(true, controller.createRubric("Maths"),
				 "Rubric was not created"); 
	}
	
	@Test
	@DisplayName("Creating rubric with incorrect name should not work")
	public void createIncorrectRubricTest() {
		assertEquals(false, controller.createRubric(""),
				 "Rubric should not be created"); 
	}
	
	@Test
	@DisplayName("Creating duplicate rubric should not work")
	public void createDuplcateRubricTest() {
		assertEquals(true, controller.createRubric("Maths"),
				 "Rubric was not created"); 
		assertEquals(false, controller.createRubric("Maths"),
				 "Rubric was not created"); 
	}
	
	@Test
	@DisplayName("Adding criterion to rubric should work")
	public void addCriterionTest() {
		assertEquals(true, controller.createRubric("Maths"),
				 "Rubric was not created"); 
		assertEquals(true, controller.addCriterion("Maths", "addition"),
				 "Criterion should be added"); 
	}
	
	@Test
	@DisplayName("Adding criterion to non existing rubric should not work")
	public void addCriterionNonExistingRubricTest() {
		assertEquals(false, controller.addCriterion("english", "nouns"),
				 "Criterion should not be added"); 
	}
	
	@Test
	@DisplayName("Adding more than ten criterion should not work")
	public void addMoreThanTenCriterionTest() {
		assertEquals(true, controller.createRubric("Maths"),
				 "Rubric was not created"); 
		assertEquals(true, controller.addCriterion("Maths", "addition"),
				 "Criterion 1 should be added"); 
		assertEquals(true, controller.addCriterion("Maths", "subtraction"),
				 "Criterion 2 should be added"); 
		assertEquals(true, controller.addCriterion("Maths", "multiplication"),
				 "Criterion 3 should be added"); 
		assertEquals(true, controller.addCriterion("Maths", "division"),
				 "Criterion 4 should be added"); 
		assertEquals(true, controller.addCriterion("Maths", "percentages"),
				 "Criterion 5 should be added"); 
		assertEquals(true, controller.addCriterion("Maths", "algebra"),
				 "Criterion 6 should be added"); 
		assertEquals(true, controller.addCriterion("Maths", "calculus"),
				 "Criterion 7 should be added"); 
		assertEquals(true, controller.addCriterion("Maths", "constants"),
				 "Criterion 8 should be added"); 
		assertEquals(true, controller.addCriterion("Maths", "equations"),
				 "Criterion 9 should be added"); 
		assertEquals(true, controller.addCriterion("Maths", "geometry"),
				 "Criterion 10 should be added"); 
		assertEquals(false, controller.addCriterion("Maths", "functions"),
				 "Criterion 11 should not be added"); 
	}
	
	
	@Test
	@DisplayName("Display rubrics should work")
	public void getRubricListTest() {
		assertEquals("No Rubrics Added." , controller.listAllRubrics(),
				 "No rubrics should be displayed"); 
		assertEquals(true , controller.createRubric("python"),
				 "Rubric should be created"); 
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals("python\nCriteria: \njava\nCriteria: design: 0, implementation: 0, \n" , controller.listAllRubrics(),
				 "List of rubrics should be displayed"); 
		
	}
	
	@Test
	@DisplayName("Display specific rubric should work")
	public void getRubricByNameTest() {
		assertEquals("No Matching Rubric Found." , controller.showRubricByName("maths"),
				 "Showing error message when searching for non existing rubric should work"); 
		assertEquals(true , controller.createRubric("python"),
				 "Rubric should be created"); 
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals("python\nCriteria: " , controller.showRubricByName("python"),
				 "Python rubric should be displayed"); 
		assertEquals("java\nCriteria: design: 0, implementation: 0, " , controller.showRubricByName("java"),
				 "Java rubrics should be displayed"); 
		
	}
	
	
	@Test
	@DisplayName("Creating a student grade should work")
	public void createStudentGradeTest() {
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals(true , controller.createGrade("Aaron", "java"),
				 "StudentGrade should be created"); 
		
	}
	
	@Test
	@DisplayName("Creating a student grade for non existing rubric should not work")
	public void createStudentGradeForNonexistingRubricTest() {
		assertEquals(false , controller.createGrade("Aaron", "python"),
				 "StudentGrade should not be created"); 
		
	}
	
	@Test
	@DisplayName("Ading a score to a criterion should work")
	public void addScoreToGradeTest() {
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals(true , controller.createGrade("Aaron", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "design", 3),
				 "Criterion grade should be updated"); 
		
	}
	
	@Test
	@DisplayName("Adding a score above 5 to a criterion should not work")
	public void addScoreAbove5ToGradeTest() {
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals(true , controller.createGrade("Aaron", "java"),
				 "grade should be created"); 
		assertEquals(false , controller.addScoreToCriterion("Aaron", "java", "design", 6),
				 "Criterion grade should not be updated"); 
		
	}
	
	@Test
	@DisplayName("Adding a score a criterion that doesnt exist should not work")
	public void addScoreToNonExistingCriterionTest() {
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals(true , controller.createGrade("Aaron", "java"),
				 "grade should be created"); 
		assertEquals(false , controller.addScoreToCriterion("Aaron", "java", "documentation", 3),
				 "Criterion grade should not be updated"); 
		
	}
	
	@Test
	@DisplayName("Adding a score a rubric that doesnt exist should not work")
	public void addScoreToNonExistingRubricTest() {
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals(true , controller.createGrade("Aaron", "java"),
				 "grade should be created"); 
		assertEquals(false , controller.addScoreToCriterion("Aaron", "python", "design", 3),
				 "Criterion grade should not be updated"); 
		
	}
	
	@Test
	@DisplayName("Adding a score a student that doesnt exist should not work")
	public void addScoreToNonExistingStudentTest() {
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals(true , controller.createGrade("Aaron", "java"),
				 "grade should be created"); 
		assertEquals(false , controller.addScoreToCriterion("Jamie", "java", "design", 3),
				 "Criterion grade should not be updated"); 
		
	}
	
	@Test
	@DisplayName("Getting all grades for a rubric should work")
	public void getAllStudentGradesForRubricTest() {
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals(true , controller.createGrade("Aaron", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "design", 3),
				 "score should be added"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "implementation", 4),
				 "score should be added"); 
		assertEquals(true , controller.createGrade("Jamie", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Jamie", "java", "design", 2),
				 "score should be added"); 
		assertEquals(true , controller.addScoreToCriterion("Jamie", "java", "implementation", 2),
				 "score should be added"); 
		assertEquals("Aaron: 7\nJamie: 4\n" , controller.allGradesForRubric("java"),
				 "correct grades should be shown"); 
		
	}
	
	
	@Test
	@DisplayName("Getting all grades for rubric with no grades should show error")
	public void getAllStudentGradesForRubricWithNoGradesTest() {
		assertEquals("No grades found for that rubric." , controller.allGradesForRubric("java"),
				 "error should be shown"); 
	}
	
	@Test
	@DisplayName("Get average score for rubric")
	public void rubricSummaryAverageTest() {
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals(true , controller.createGrade("Aaron", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "design", 3),
				 "score should be added"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "implementation", 4),
				 "score should be added"); 
		assertEquals(true , controller.createGrade("Jamie", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Jamie", "java", "design", 2),
				 "score should be added"); 
		assertEquals(true , controller.addScoreToCriterion("Jamie", "java", "implementation", 2),
				 "score should be added"); 
		assertEquals(5.5 , controller.rubricSummaryAverage("java"),
				 "correct average should be returned"); 
	}
	
	@Test
	@DisplayName("Get standard deviation for rubric")
	public void rubricSummaryStandardDeviationTest() {
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals(true , controller.createGrade("Aaron", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "design", 3),
				 "score should be added"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "implementation", 4),
				 "score should be added"); 
		assertEquals(true , controller.createGrade("Jamie", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Jamie", "java", "design", 2),
				 "score should be added"); 
		assertEquals(true , controller.addScoreToCriterion("Jamie", "java", "implementation", 2),
				 "score should be added"); 
		assertEquals(1.5 , controller.rubricSummaryStandardDeviation("java"),
				 "correct standard deviation should be returned"); 
	}
	
	@Test
	@DisplayName("Get max and min for rubric")
	public void rubricSummaryMaxMinTest() {
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals(true , controller.createGrade("Aaron", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "design", 3),
				 "score should be added"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "implementation", 4),
				 "score should be added"); 
		assertEquals(true , controller.createGrade("Jamie", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Jamie", "java", "design", 2),
				 "score should be added"); 
		assertEquals(true , controller.addScoreToCriterion("Jamie", "java", "implementation", 2),
				 "score should be added"); 
		assertEquals("Max: 7\nMin: 4" , controller.rubricSummaryMaxMin("java"),
				 "correct Max Min should be returned"); 
	}
	
	@Test
	@DisplayName("Get average score for criterion in rubric")
	public void criterionSummaryAverageTest() {
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals(true , controller.createGrade("Aaron", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "design", 3),
				 "score should be added"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "implementation", 4),
				 "score should be added"); 
		assertEquals(true , controller.createGrade("Jamie", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Jamie", "java", "design", 2),
				 "score should be added"); 
		assertEquals(true , controller.addScoreToCriterion("Jamie", "java", "implementation", 2),
				 "score should be added"); 
		assertEquals(3 , controller.criterionSummaryAverage("java", "implementation"),
				 "correct average should be returned"); 
	}
	
	@Test
	@DisplayName("Get standard deviation for criterion in rubric")
	public void criterionSummaryStandardDeviationTest() {
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals(true , controller.createGrade("Aaron", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "design", 3),
				 "score should be added"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "implementation", 4),
				 "score should be added"); 
		assertEquals(true , controller.createGrade("Jamie", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Jamie", "java", "design", 2),
				 "score should be added"); 
		assertEquals(true , controller.addScoreToCriterion("Jamie", "java", "implementation", 2),
				 "score should be added"); 
		assertEquals(1 , controller.criterionSummaryStandardDeviation("java", "implementation"),
				 "correct standard deviation should be returned"); 
	}
	
	@Test
	@DisplayName("Get max and min for criterion in rubric")
	public void criterionSummaryMaxMinTest() {
		assertEquals(true , controller.createRubric("java"),
				 "Rubric should be created"); 
		assertEquals(true , controller.addCriterion("java", "design"),
				 "criterion should be added"); 
		assertEquals(true , controller.addCriterion("java", "implementation"),
				 "criterion should be added"); 
		assertEquals(true , controller.createGrade("Aaron", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "design", 3),
				 "score should be added"); 
		assertEquals(true , controller.addScoreToCriterion("Aaron", "java", "implementation", 4),
				 "score should be added"); 
		assertEquals(true , controller.createGrade("Jamie", "java"),
				 "grade should be created"); 
		assertEquals(true , controller.addScoreToCriterion("Jamie", "java", "design", 2),
				 "score should be added"); 
		assertEquals(true , controller.addScoreToCriterion("Jamie", "java", "implementation", 2),
				 "score should be added"); 
		assertEquals("Max: 4\nMin: 2" , controller.criterionSummaryMaxMin("java", "implementation"),
				 "correct Max Min should be returned"); 
	}
	
	
	

}
