package net.deile.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class TestFilter extends UsernamePasswordAuthenticationFilter {

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {

		final String mail = (String) req.getAttribute("email");
		final String pswd = (String) req.getAttribute("pswd");

		final UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(mail, pswd);

		return getAuthenticationManager().authenticate(creds);

//		return super.attemptAuthentication(req, res);
	}

}
