package net.deile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.deile.service.LoginUserService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	LoginUserService loginUserService;

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
	public String loginPost(@RequestParam("email") String email, @RequestParam("pswd") String pswd, Model model) {

		loginUserService.authenticationLogin(email, pswd);

		return "login";
	}

}
