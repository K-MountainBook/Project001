package net.deile.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.deile.entity.User;
import net.deile.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@Autowired
	UserRepository userRepository;

	@GetMapping("profile")
	public String profileview(Model model) {
		String template = "profile";
		return template;
	}

	@GetMapping("")
	public String viewprofile(@RequestParam(name = "email", required = true) String email, Model model) {
		String template = "user_profile";
		// ユーザ情報を取得して、Viewへ渡す。
		List<User> userInfo = userRepository.findByEmail(email);

		if (userInfo.isEmpty()) {
			// ユーザが存在しません。
			template = "user_notfound";
		}

		// ログインユーザ = 表示要求ユーザでない場合の処理

		return template;
	}

}
