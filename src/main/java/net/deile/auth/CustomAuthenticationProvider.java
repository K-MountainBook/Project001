package net.deile.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();

	}

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		logger.info("Run CustomAuthenticationProvider");

		User user = (User) auth.getPrincipal();
		Object password = auth.getCredentials();

		// DBからユーザを抽出する。
		List<User> users = userDetailService.findByEmail(user.getEmail());
		User findUser = new User();

		if (users.size() != 1 || users == null) {
			// エラー
			logger.info("Can not find user");
			throw new BadCredentialsException("email or passwod error");
		} else {
			findUser = users.get(0);
		}

		// パスワードの整合性チェック
		if (passwordEncoder().matches(user.getPassword(), findUser.getPassword())) {
			// パスワード一致
		} else {
			// パスワードが一致しないのでエラー
			logger.info("No match password");
			throw new BadCredentialsException("email or passwod error");
		}

		user.setUser_name(findUser.getUser_name());

		Collection<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

		return new UsernamePasswordAuthenticationToken(user, password, authorityList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
