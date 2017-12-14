package controllers;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.DAOException;
import models.BO.PostBO;
import models.DTO.Post;
import models.utils.SessionManager;

public class EditPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PostBO postBO;
	MessageDigest md;

	public EditPostServlet() {
		super();
		postBO = new PostBO();

		// Get MD5 hash for generate CSRF token.
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String targetPage = "";

		// Query post by post id.
		Post post = postBO.findPostById(request.getParameter("id"));

		if (post != null) {
			// Populate post to request attribute for render on view.
			request.setAttribute("post", post);

			// Set target view is post edit page.
			targetPage = "/WEB-INF/pages/post-edit.jsp";
		} else {
			// If found not found, send user to not found page.
			request.setAttribute("message", "Post not found.");
			targetPage = "/WEB-INF/pages/404.jsp";
		}

		// Create dispatcher for forward data for JSP file.
		RequestDispatcher rd = request.getRequestDispatcher(targetPage);

		// Forward all data to homepage.jsp file for process render view.
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Post p = new Post();

		// Must set encoding.
		request.setCharacterEncoding("UTF-8");

		p.setId(request.getParameter("pId"));
		p.setName(request.getParameter("pName"));
		p.setDescription(request.getParameter("pDescription"));
		p.setContent(request.getParameter("pContent"));

		request.setAttribute("post", p);

		// Validate CSRF token.
		if (SessionManager.validateCSRFToken(request)) {
			try {
				postBO.update(p);
				request.setAttribute("message", "Update post successfully.");
			} catch (DAOException e) {
				request.setAttribute("message", e.getMessage());
			}
		} else {
			request.setAttribute("message", "CSRF token not valid.");
		}

		request.getRequestDispatcher("/WEB-INF/pages/post-edit.jsp").forward(request, response);
	}
}
