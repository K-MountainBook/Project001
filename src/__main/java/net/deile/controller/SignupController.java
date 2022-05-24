package net.deile.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * "/signup"配下のパスへのアクセスコントローラ
 * 
 * @author k_yamamoto
 *
 */
@Controller
@RequestMapping("/signup")
public class SignupController {

	Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;

	/**
	 * サインアップページへのアクセス(Get)
	 * 
	 * @param form  SinginForm
	 * @param model {@link org.springframework.ui.Model}
	 * @return Template Name
	 */
	@GetMapping("")
	public String singuptio(@ModelAttribute SigninForm form, Model model) {
		String template = "signup";
		return template;
	}

	/**
	 * サインアップページへのアクセス(Post)
	 * 
	 * @param form      SingnForm
	 * @param model     {@link org.springframework.ui.Model}
	 * @param principal {@link java.security.Principal}
	 * @return Template Name
	 */
	@PostMapping("")
	public String singupForm(@ModelAttribute("signinForm") @Validated SigninForm form, Model model,
			Principal principal) {

		String template = "index";

		if (principal == null) {

			User user = new User();
			// emailアドレスとパスワードを検証
			user.setEmail(form.getEmail());
			user.setPassword(form.getPswd());
			user.setBio("");
			user.setFacebook("");
			user.setGroup_id("");
			user.setHomepage("");
			user.setTwitter("");
			user.setUser_name("");

			String uuid = UUID.randomUUID().toString();
			// UUIDの重複チェックを一応行う
			user.setUUID(userDetailServiceImpl.checkUuid(uuid));

			if (user.getEmail() == null || user.getPassword() == null || user.getEmail().trim().isEmpty()
					|| user.getPassword().trim().isEmpty()) {
				logger.warn("email or password is empty");
				// 必須項目が入力されていないエラー
				template = "signup";
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
					logger.error(e.getMessage());
					template = "exception";
				}
			}

		} else {
			// ログイン済み
			// indexへ戻す。
		}

		return template;
	}

	/**
	 * サインアップ確認画面(Get)
	 * 
	 * @param model {@link org.springframework.ui.Model}
	 * @return Template Name
	 */
	@GetMapping("signupconfirm")
	public String signupConfirm(Model model) {
		String template = "signupconfirm";
		return template;
	}

}
