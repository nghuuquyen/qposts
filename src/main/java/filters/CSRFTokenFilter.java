package filters;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CSRFTokenFilter implements Filter {
	SecureRandom random;
	byte bytes[] = new byte[10];

	public CSRFTokenFilter() {
		random = new SecureRandom();
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		// Do generate CSRF Token.
		random.nextBytes(bytes);

		String token = new BigInteger(1, bytes).toString(16);

		HttpServletRequest request = (HttpServletRequest) req;

		// Do set token to session for validate after.
		request.getSession().setAttribute("_csrf", token);

		// Set token to request attribute for render on view page.
		request.setAttribute("_csrf", token);

		chain.doFilter(req, res);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
}
