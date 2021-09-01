package net.deile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import net.deile.service.LoginUserService;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("profile")
	public String profileview(Model model) {
		return "profile";
	}

	@GetMapping("login")
	public String loginGet(Model model) {
		return "login";
	}

}
