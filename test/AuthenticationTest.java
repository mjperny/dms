import groovy.ui.text.FindReplaceUtility;
import models.User;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;

/**
 * Tests the authentification by using test data from user.yml
 * The test data yml files are all in the test directory.
 * @author Gary
 * @version 2014-06-13
 */
public class AuthenticationTest extends UnitTest{
	@Before
	public void setUp(){
		Fixtures.deleteAllModels();
		Fixtures.loadModels("authentication.yml");
		User user = User.find("byName", "gary").first();
		System.out.println(user.id);
	}

	
	@Test(expected=AuthenticationException.class)
	public void testAuthFailed(){
		Subject user = SecurityUtils.getSubject();
		String username = "gary";
		String password = "wrongpassword";
		
		user.login(new UsernamePasswordToken(username, password));
	}
	
	@Test(expected=AuthenticationException.class)
	public void testAuthFailedWithNoPassword(){
		Subject user = SecurityUtils.getSubject();
		String username = "gary";
		String password = "";
		
		user.login(new UsernamePasswordToken(username, password));
	}
	@Test(expected=AuthenticationException.class)
	public void testAuthFailedWithNoUsername(){
		Subject user = SecurityUtils.getSubject();
		String username = "";
		String password = "password";
		
		user.login(new UsernamePasswordToken(username, password));
	}
	
	@Test
	public void testAuthSuccessful(){
		Subject user = SecurityUtils.getSubject();
		String username = "gary";
		String password = "password";
		
		user.login(new UsernamePasswordToken(username, password));
	}
}
