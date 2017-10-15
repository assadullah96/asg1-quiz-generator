package asgAP;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class attemptQuizTest {

	@Test
	public void test() {
		try {
			attemptQuiz aq = new attemptQuiz();
			assertFalse(aq.check());   
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
