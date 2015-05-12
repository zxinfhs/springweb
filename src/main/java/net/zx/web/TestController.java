package net.zx.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping(value="/test1/{msg}")
	public ModelAndView test1(@PathVariable String msg) {
		return new ModelAndView("hello", "message", "Msg on test1 is " + msg);
	}
	
	@RequestMapping(value="/test2/{msg}")
	public String test2(@PathVariable String msg, Model model) {
		model.addAttribute("message", "Msg on test2 is " + msg);
		return "hello";
	}
}
