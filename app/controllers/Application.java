package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

/**
 * The main application controller
 * @author Gary Ye
 * @version 2014-06-13
 */
public class Application extends Controller {
    public static void index() {
        render();
    }
}