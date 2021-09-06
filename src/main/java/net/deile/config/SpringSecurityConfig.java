package net.deile.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.deile.auth.CustomAuthenticationFilter;
import net.deile.auth.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomAuthenticationProvider authenticationProvider;

	/**
	 * <ul>
	 * <li>bcrypt - {@link BCryptPasswordEncoder} (Also used for encoding)</li>
	 * <li>ldap -
	 * {@link org.springframework.security.crypto.password.LdapShaPasswordEncoder}</li>
	 * <li>MD4 -
	 * {@link org.springframework.security.crypto.password.Md4PasswordEncoder}</li>
	 * <li>MD5 - {@code new MessageDigestPasswordEncoder("MD5")}</li>
	 * <li>noop -
	 * {@link org.springframework.security.crypto.password.NoOpPasswordEncoder}</li>
	 * <li>pbkdf2 - {@link Pbkdf2PasswordEncoder}</li>
	 * <li>scrypt - {@link SCryptPasswordEncoder}</li>
	 * <li>SHA-1 - {@code new MessageDigestPasswordEncoder("SHA-1")}</li>
	 * <li>SHA-256 - {@code new MessageDigestPasswordEncoder("SHA-256")}</li>
	 * <li>sha256 -
	 * {@link org.springframework.security.crypto.password.StandardPasswordEncoder}</li>
	 * <li>argon2 - {@link Argon2PasswordEncoder}</li>
	 * </ul>
	 *
	 * @return the {@link PasswordEncoder} to use
	 */

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// アクセスコントロールの設定
		http.authorizeRequests().anyRequest().permitAll();
		// ログイン画面の設定
		http.formLogin().loginPage("/login").defaultSuccessUrl("/dashboard").failureUrl("/login?error")
				.usernameParameter("email").passwordParameter("pswd");
		http.logout().logoutSuccessUrl("/").permitAll();
		CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
		filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
		filter.setAuthenticationManager(authenticationManagerBean());
		// filter.setAuthenticationFailureHandler(new
		// SimpleUrlAuthenticationFailureHandler("/login?error"));

		http.addFilterBefore(filter, CustomAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(authenticationProvider);
	}

}
