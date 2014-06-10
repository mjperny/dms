package controllers;

import static play.data.Form.*;
import play.*;
import play.db.jpa.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    public static Result login() {
        return ok(
          login.render()
        );
    }
    public static Result createDocument() {
      return ok(
        createDocument.render(form(CreateDocument.class))
      );
    }
    
    @Transactional
    public static Result test() { 
    	return TODO;
    }

public static class CreateDocument {
    public String name;
    public String comment;

}
}
