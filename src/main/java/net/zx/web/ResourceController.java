package net.zx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class ResourceController {
	@RequestMapping(value="/test1/{msg}")
	public ModelAndView test1(@PathVariable String msg) {
		return new ModelAndView("hello", "message", "Msg on test1 is " + msg);
	}
}
