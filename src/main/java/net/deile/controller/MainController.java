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

	@GetMapping({ "", "index" })
	public String index(Model model) {
		String template = "index";
		return template;
	}

	@GetMapping("dashboard")
	public String showDashboard(@AuthenticationPrincipal User user, Model model) {
		String template = "dashboard";
		// 参加する予定のカレンダー

		// 参加する予定のイベントの一覧

		return template;

	}
}
