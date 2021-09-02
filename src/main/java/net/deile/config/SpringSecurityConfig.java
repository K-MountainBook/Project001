package net.deile.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.AbstractPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import net.deile.filter.TestProvider;
import net.deile.service.AccountDetailService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource datasource;

	@Autowired
	AccountDetailService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		return new BCryptPasswordEncoder();

	}

	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(this.passwordEncoder());
		return authProvider;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().permitAll();
		// ログイン関連の処理
		http.formLogin().loginPage("/login").defaultSuccessUrl("/").failureUrl("/login").usernameParameter("email")
				.passwordParameter("pswd");
		// http.authorizeRequests().antMatchers("/product/**").permitAll().anyRequest().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("run configure auth");

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		super.configure(auth);
	}

}
