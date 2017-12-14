package models.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionManager {

	public static boolean validateCSRFToken(HttpServletRequest req) {
		// Token generate by system.
		String validToken = (String) req.getSession().getAttribute("_csrf");

		// Token send in request by user form.
		String userToken = (String) req.getAttribute("_csrf");

		return validToken.equalsIgnoreCase(userToken);
	}
}
