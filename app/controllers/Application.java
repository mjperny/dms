package controllers;

import static play.data.Form.*;
import model.User;
import play.data.Form;
import play.db.jpa.*;
import play.mvc.*;
import views.html.*;

/**
 * 
 * @version 2014-06-07
 */
public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result login() {
		return ok(login.render(form(model.User.class)));
	}

	public static Result createDocument() {
		return ok(createDocument.render(form(model.Document.class)));
	}

	@Transactional
	public static Result test() {
		return TODO;
	}

	
	public static Result authenticate() {
		Form<User> loginForm = form(User.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else {
			session().clear();
			session("name", loginForm.get().getName());
			return redirect(routes.Application.index());
		}
	}

}
