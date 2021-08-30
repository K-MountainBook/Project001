package net.deile.filter;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestProvider extends DaoAuthenticationProvider {

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO 自動生成されたメソッド・スタブ
		super.additionalAuthenticationChecks(userDetails, authentication);
	}

	@Override
	protected void doAfterPropertiesSet() {
		// TODO 自動生成されたメソッド・スタブ
		super.doAfterPropertiesSet();
	}

	@Override
	protected Authentication createSuccessAuthentication(Object principal, Authentication authentication,
			UserDetails user) {
		// TODO 自動生成されたメソッド・スタブ
		return super.createSuccessAuthentication(principal, authentication, user);
	}

	@Override
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		// TODO 自動生成されたメソッド・スタブ
		super.setPasswordEncoder(passwordEncoder);
	}

	@Override
	protected PasswordEncoder getPasswordEncoder() {
		// TODO 自動生成されたメソッド・スタブ
		return super.getPasswordEncoder();
	}

	@Override
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		// TODO 自動生成されたメソッド・スタブ
		super.setUserDetailsService(userDetailsService);
	}

	@Override
	protected UserDetailsService getUserDetailsService() {
		// TODO 自動生成されたメソッド・スタブ
		return super.getUserDetailsService();
	}

	@Override
	public void setUserDetailsPasswordService(UserDetailsPasswordService userDetailsPasswordService) {
		// TODO 自動生成されたメソッド・スタブ
		super.setUserDetailsPasswordService(userDetailsPasswordService);
	}

}
