package net.zx.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/welcome")
public class HelloController {
 
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String printWelcome(ModelMap model) {
		System.out.println("execute printWelcome");
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";
 
	}
 
}