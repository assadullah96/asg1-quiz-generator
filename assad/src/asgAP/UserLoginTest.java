package asgAP;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserLoginTest {

	@Test
	public void test() {
		UserLogin test1=new UserLogin();
		assertTrue(test1.checkLogin());
		//assertFalse(test1.checkLogin());        //check the test case 
	}

	
	
}
