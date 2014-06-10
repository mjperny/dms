package controllers;

import static play.data.Form.*;
import play.*;
import play.db.jpa.*;
import play.mvc.*;
import views.html.*;
import static play.data.Form.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    public static Result login() {
       return ok(
            login.render(form(Login.class))
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
public static Result authenticate() {
    Form<Login> loginForm = form(Login.class).bindFromRequest();
    if (loginForm.hasErrors()) {
        return badRequest(login.render(loginForm));
    } else {
        session().clear();
        session("name", loginForm.get().name);
        return redirect(
            routes.Application.index()
        );
    }
}

public String validate() {
    if (User.authenticate(name, password) == null) {
      return "Invalid user or password";
    }
    return null;
}
public static class Login {

    public String name;

}
}
