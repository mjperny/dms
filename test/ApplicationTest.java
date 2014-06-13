import org.junit.*;

import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;

/**
 * 
 * Tests the application by doing some requests.
 * @version 2014-06-13
 */
public class ApplicationTest extends FunctionalTest {
    @Test
    public void testThatIndexPageWorks() {
        Response response = GET("/");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
}