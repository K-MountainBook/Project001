package net.deile.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import net.deile.entity.User;
import net.deile.service.UserDetailServiceImpl;

@Configuration
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserDetailServiceImpl userDetailService;

	Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();

	}

	/**
	 * 認証/認可処理
	 */
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		logger.info("Run CustomAuthenticationProvider");

		String user_email = (String) auth.getPrincipal();
		String password = (String) auth.getCredentials();

		// DBからユーザを抽出する。
		List<User> users = userDetailService.findByEmail(user_email);
		User findUser;

		// 抽出した件数が1件以外であればエラー
		if (users.size() != 1 || users == null) {
			logger.warn("Can not find user");
			throw new BadCredentialsException("email or passwod error");
		} else {
			findUser = users.get(0);
		}

		// パスワードの整合性チェック
		if (passwordEncoder().matches(password, findUser.getPassword())) {
			// パスワード一致
			logger.info("Login success : " + user_email);
		} else {
			// パスワードが一致しないのでエラー
			logger.warn("No match password");
			throw new BadCredentialsException("email or passwod error");
		}

		// DBから抽出したユーザ情報を設定
		findUser.setEmail(user_email);
		findUser.setPassword("");
		findUser.setUser_name(findUser.getUser_name());
		findUser.setUUID(findUser.getUUID());

		// ロールの追加
		Collection<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

		return new UsernamePasswordAuthenticationToken(findUser, password, authorityList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
