package controllers;

import play.*;
import play.db.jpa.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    @Transactional
    public static Result test() { 
    	return TODO;
    }
}
