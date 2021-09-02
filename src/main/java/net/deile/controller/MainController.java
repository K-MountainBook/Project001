package net.deile.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.deile.entity.User;

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

	@PostMapping("login")
	public String loginCheck(@AuthenticationPrincipal User user) {

		return "index";

	}
}
