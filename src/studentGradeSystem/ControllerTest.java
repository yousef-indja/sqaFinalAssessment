package studentGradeSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class ControllerTest {

	private Rubric rubric;
	
	private Controller controller;
	@BeforeEach
	public void setUp()throws Exception{
		controller = new Controller();
	}
	
	@Test
	@DisplayName("Creating new rubric should work")
	public void createRubricTest() {
		rubric = new Rubric();
		assertEquals(rubric.getClass(), controller.createRubric(),
				 "creating rubric should work"); 
	}
	
	

}
