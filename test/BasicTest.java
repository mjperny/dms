import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.dom4j.dom.DOMEntityReference;
import org.junit.*;

import dao.UserDAO;

import java.util.*;

import play.db.jpa.JPA;
import play.test.*;
import model.*;

public class BasicTest extends UnitTest {

	@Test
	public void aVeryImportantThingToTest() {
		assertEquals(2, 1 + 1);
	}

	@BeforeClass
	public static void setup() {
		User user = new User();
		user.setName("gary");
		user.setPassword("testpassword");
		user.save();

		Document document = new Document();
		document.setName("Das Dokument");
		document.save();
		
		JPA.em().flush();
		JPA.em().getTransaction().commit();
		JPA.em().getTransaction().begin();
	}

	@Test
	public void testPermission() {
		Subject currentUser = SecurityUtils.getSubject();
		User user = User.find("byName", "gary").first();
		currentUser.login(new UsernamePasswordToken(user.getName(),	user.getPassword()));

		Document document = Document.find("byName", "Das Dokument").first();		
		
		Role role = new RoleFileOwner(document.getId());
		role.save();
		
		PermissionManager.getInstance().grantAccess(user, role);
		
		assertTrue(currentUser.isPermitted(new PermissionReadWrite(document
				.getId()).toString()));
	}

}
