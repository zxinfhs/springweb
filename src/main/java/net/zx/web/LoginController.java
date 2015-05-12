package net.zx.web;
/*
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class LoginController {
	
	@RequestMapping(value="/login") 
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping("/hello")
	public ModelAndView helloWorld() {

		String message = "Hello World, Spring 3.110!";
		System.out.println(message);
		return new ModelAndView("hello", "message", message);
	}
	
	@RequestMapping(value="/doLogin")
	public ModelAndView doLogin() {
		System.out.println("exe dologin");
		ModelAndView mv = new ModelAndView("main");
		mv.addObject("message", "re mod and view");
		return mv;
	}
}
