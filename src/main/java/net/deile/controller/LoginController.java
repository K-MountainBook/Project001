package net.deile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * "/login"配下のパスへのアクセスコントローラ
 * 
 * @author k_yamamoto
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	// PostLoginは自動で行われる

	@GetMapping("")
	public String loginGet(Model model) {
		String template = "login";
		// ログイン画面へ遷移
		return template;
	}

}
