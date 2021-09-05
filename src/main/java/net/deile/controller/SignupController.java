package net.deile.controller;

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

	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;

	@GetMapping("")
	public String singuptio(Model model) {
		return "signup";
	}

	@PostMapping("")
	public String singupForm(@ModelAttribute("signinForm") SigninForm form, Model model) {
		//		System.out.println(form.getEmail());
		//		System.out.println(form.getPswd());
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

		// userテーブルへ登録
		userDetailServiceImpl.signUpUser(user);

		return "index";
	}

}
