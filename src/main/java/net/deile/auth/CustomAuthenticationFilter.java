package net.deile.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {

		logger.info("Run CustomAuthenticationFilter");

		// トークンの作成
		UsernamePasswordAuthenticationToken authreq = new UsernamePasswordAuthenticationToken(req.getParameter("email"),
				req.getParameter("pswd"));

		setDetails(req, authreq);

		// Managerを経由してAuthenticationProviderを使用
		return this.getAuthenticationManager().authenticate(authreq);
	}

}
