package net.deile.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.deile.entity.User;
import net.deile.form.UserProfileForm;
import net.deile.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@Autowired
	UserRepository userRepository;

	@GetMapping("profile")
	public String profileview(@ModelAttribute UserProfileForm form, Model model) {
		String template = "user_profile_edit";
		return template;
	}

	@PostMapping("profile")
	public String profileForm(@ModelAttribute(value = "userProfileForm") UserProfileForm form, Model model) {
		String template = "user_profile_edit";
		return template;
	}

	@GetMapping("/{email}")
	public String viewprofile(@PathVariable("email") String email, Model model) {
		String template = "user_profile";
		// ユーザ情報を取得して、Viewへ渡す。
		List<User> userInfo = userRepository.findByEmail(email);
		if (userInfo.isEmpty()) {
			// ユーザが存在しません。
			template = "user_notfound";
		}

		User user = userInfo.get(0);

		model.addAttribute("user", user);

		// ログインユーザ = 表示要求ユーザでない場合の処理
		return template;
	}

}
