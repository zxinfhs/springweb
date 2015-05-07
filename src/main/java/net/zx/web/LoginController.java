package net.zx.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public void doLogin(Model model) {
		System.out.println("exe dologin");
		
	}
}
