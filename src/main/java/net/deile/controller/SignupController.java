package net.deile.controller;

import java.security.Principal;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.deile.entity.User;
import net.deile.form.SigninForm;
import net.deile.service.UserDetailServiceImpl;

@Controller
@RequestMapping("/signup")
public class SignupController {

	Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;

	@GetMapping("")
	public String singuptio(@ModelAttribute SigninForm form, Model model) {
		String template = "signup";
		return template;
	}

	@PostMapping("")
	public String singupForm(@ModelAttribute("signinForm") @Validated SigninForm form, Model model,
			Principal principal) {

		String template = "index";

		if (principal == null) {

		} else {
			// ログイン済み
		}

		User user = new User();
		// emailアドレスとパスワードを検証
		user.setEmail(form.getEmail());
		user.setPassword(form.getPswd());
		user.setBio("");
		user.setFacebook("");
		user.setGroup_id("");
		user.setHomepage("");
		user.setTwitter("");
		user.setUser_id("");
		user.setUser_name("");

		if (user.getEmail() == null || user.getPassword() == null || user.getEmail().trim().isEmpty()
				|| user.getPassword().trim().isEmpty()) {
			logger.warn("email or password is empty");
			// 必須項目が入力されていないエラー
			template = "index";
		}

		if (!user.getEmail().trim().equals("") && !user.getPassword().trim().equals("")) {
			// userテーブルへ登録
			try {
				if (userDetailServiceImpl.signUpUser(user)) {
					// 成功
					template = "signupconfirm";
				} else {
					// すでに登録されている場合
					template = "signup";
				}
			} catch (SQLException e) {
				// 更新に失敗した場合。
				e.printStackTrace();
				template = "exception";
			}
		}

		return template;
	}

	@GetMapping("signupconfirm")
	public String signupConfirm(Model model) {
		String template = "signupconfirm";
		return template;
	}

}
