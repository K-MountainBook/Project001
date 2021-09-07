package net.deile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String singuptio(Model model) {
		return "signup";
	}

	@PostMapping("")
	public String singupForm(@ModelAttribute("signinForm") SigninForm form, Model model) {

		String resultReturn = "index";

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

		if (user.getEmail().equals("") || user.getPassword().equals("")) {
			logger.warn("email or password is empty");
			resultReturn = "index";
		}

		if (!user.getEmail().equals("") && !user.getPassword().equals("")) {
			// userテーブルへ登録
			if (userDetailServiceImpl.signUpUser(user)) {
				resultReturn = "signupconfirm";
			} else {
				resultReturn = "signup";
			}
		}

		return resultReturn;
	}

	@GetMapping("signupconfirm")
	public String signupConfirm(Model model) {
		return "signupconfirm";
	}

}
