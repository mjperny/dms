import java.util.Collection;
import java.util.Locale.Category;

import models.Document;
import models.DocumentCategory;
import models.DocumentManager;
import models.DocumentType;
import models.User;

import org.junit.Before;
import org.junit.Test;

import play.db.jpa.JPA;
import play.test.Fixtures;
import play.test.UnitTest;


public class DocumentManagerTest extends UnitTest {
	@Before
	public void setUp(){
		Fixtures.deleteAllModels();
		Fixtures.loadModels("authorization.yml");
	}
	
	@Test
	public void testCreateDocument(){
		DocumentManager dm = new DocumentManager();
		User user = User.find("byName", "gary").first();
		Document doc = Document.find("byName", "doc1").first();
		assertNotNull(user);
		assertNotNull(doc);
		dm.createDocument(user, doc);
		assertNotNull(doc.getAuthor());
		assertTrue(doc.getAuthor() == user);
	}
	
	@Test
	public void testFindByNameContains(){
		DocumentManager dm = new DocumentManager();
		Collection<Document> res = dm.findByNameContains("doc");
		assertEquals(2, res.size());
	}
	
	@Test
	public void testFindByCategory(){
		DocumentManager dm = new DocumentManager();
		Collection<Document> res = dm.findByCategory(DocumentCategory.ENTERTAINEMENT);
		assertEquals(2, res.size());
	}
	
	@Test
	public void testFindByType(){
		DocumentManager dm = new DocumentManager();
		Collection<Document> res = dm.findByType(DocumentType.PICTURE);
		assertEquals(1, res.size());
	}
}
