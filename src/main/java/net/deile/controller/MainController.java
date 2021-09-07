package net.deile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.deile.entity.User;

//import net.deile.service.LoginUserService;

@Controller
@RequestMapping("/")
public class MainController {

	Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());


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

	@GetMapping("dashboard")
	public String showDashboard(@AuthenticationPrincipal User user, Model model) {

		// 参加する予定のカレンダー
		// 参加する予定のイベントの一覧

		return "dashboard";

	}
}
