package controllers;

import models.book.data.UserDTO;
import models.book.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext; 
import play.mvc.Controller;
import play.mvc.Result;
//import views.html.list;
import java.util.List;

public class Users extends Controller 
{
  public static Result list()
  {
	  ApplicationContext ctx = new FileSystemXmlApplicationContext("conf/ApplicationContext.xml");
	  UserService userService = (UserService)ctx.getBean("UserService"); 
	  List<UserDTO> users = userService.getUsers();
	  return ok();//list.render(users) 
  }
}