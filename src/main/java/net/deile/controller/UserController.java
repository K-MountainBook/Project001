package net.deile.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.deile.entity.User;
import net.deile.form.UserProfileForm;
import net.deile.repository.UserRepository;

/**
 * "/User"配下のパスへのアクセスコントローラ
 * 
 * @author k_yamamoto
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@Autowired
	UserRepository userRepository;

	/**
	 * /user/profileへのアクセス(Get)
	 * 
	 * @param form     {@link net.deile.form.UserProfileForm}
	 * @param userPrin {@link net.deile.entity.User}
	 * @param model    {@link org.springframework.ui.Model}
	 * @return Template Name
	 */
	@GetMapping("profile")
	public String profileview(@ModelAttribute UserProfileForm form, @AuthenticationPrincipal User userPrin,
			Model model) {

		String template = "user_profile_edit";
		// 編集ユーザのユーザ情報を取得する。

		Optional<User> userInfo = userRepository.findById(userPrin.getUUID());
		User user;

		if (userInfo.isPresent()) {
			user = userInfo.get();

			form.setEmail(user.getEmail());
			form.setUuid(user.getUUID());
			form.setUser_name(user.getUser_name());
			form.setBio(user.getBio());
			form.setTwitter(user.getTwitter());
			form.setFacebook(user.getFacebook());
			form.setHomepage(user.getHomepage());

		} else {
			// ユーザ情報が取得できなかった場合エラー
		}

		return template;
	}

	/**
	 * /user/profileへのアクセス(Post)
	 * 
	 * @param form  {@link net.deile.form.UserProfileForm}
	 * @param model {@link org.springframework.ui.Model}
	 * @return Template Name
	 */
	@PostMapping("profile")
	public String profileForm(@ModelAttribute(value = "userProfileForm") UserProfileForm form, Model model) {
		String template = "user_profile_edit";
		return template;
	}

	/**
	 * /user/{UUID}へのアクセス(Get)<br>
	 * {UUID}のユーザの情報を表示する。
	 * 
	 * @param username UUID
	 * @param model    {@link org.springframework.ui.Model}
	 * @return Template Name
	 */
	@GetMapping("/{username}")
	public String viewprofile(@PathVariable("username") String username, Model model) {
		String template = "user_profile";
		// ユーザ情報を取得して、Viewへ渡す。
		List<User> userInfo = userRepository.findByUserName(username);
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
