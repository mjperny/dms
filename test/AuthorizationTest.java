
import models.Document;
import models.DocumentManager;
import models.Permission;
import models.PermissionLock;
import models.PermissionReadWrite;
import models.User;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;


/**
 * Tests the authorization with some artifical test data. 
 * Namely the document ("doc1") and the author of the document ("gary") and another
 * user("tom"), who wants to access the document.
 * @author Gary Ye
 * @version 2014-06-13
 */
public class AuthorizationTest extends UnitTest {
	private User user;
	private Document document;
	private Subject subject;
	
	@Before
	public void setUp(){
	    Fixtures.deleteAllModels();
	    Fixtures.loadModels("authorization.yml");
	    
	    DocumentManager dm = new DocumentManager();
		user = User.find("byName", "gary").first();
		document = Document.find("byName", "doc1").first();
		dm.createDocument(user, document);
		
		subject = SecurityUtils.getSubject();
		subject.login(new UsernamePasswordToken("tom", "letmein"));
	}
	
	@Test
	public void testGiveNoAccess(){
		Permission permissionReadWrite = new PermissionReadWrite(document.getId());
		Permission permissionLock = new PermissionLock(document.getId());

		assertFalse(subject.isPermitted(permissionReadWrite.toString()));
		assertFalse(subject.isPermitted(permissionLock.toString()));
	}
	
	@Test
	public void testGiveAccess(){
		User user = User.find("byName", "tom").first();
		(new DocumentManager()).giveUsingAccess(user, document);
		
		Permission permissionReadWrite = new PermissionReadWrite(document.getId());
		Permission permissionLock = new PermissionLock(document.getId());

		assertTrue(subject.isPermitted(permissionReadWrite.toString()));
		assertFalse(subject.isPermitted(permissionLock.toString()));
	}
}
