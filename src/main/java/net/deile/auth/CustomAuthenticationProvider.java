package net.deile.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
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

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();

	}

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		System.out.println("Run CustomAuthenticationProvider");

		User user = (User) auth.getPrincipal();
		Object password = auth.getCredentials();

		// ここで認証とロールの付与
		System.out.println(passwordEncoder().encode(user.getPassword()));

		// DBからユーザを抽出する。
		List<User> users = userDetailService.findByEmail(user.getEmail());
		User findUser = new User();

		if (users.size() != 1 || users == null) {
			// エラー
			throw new BadCredentialsException("email or passwod error");
		} else {
			findUser = users.get(0);
		}

		// パスワードの整合性チェック
		if (passwordEncoder().matches(user.getPassword(), findUser.getPassword())) {
			System.out.println("password accepted");
		} else {
			// パスワードが一致しないのでエラー
			throw new BadCredentialsException("email or passwod error");
		}

		user.setUser_name(findUser.getUser_name());

		Collection<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

		// return new UsernamePasswordAuthenticationToken(user, password,
		// auth.getAuthorities());
		return new UsernamePasswordAuthenticationToken(user, password, authorityList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
