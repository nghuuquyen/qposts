package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BO.PostBO;
import models.DTO.Post;

public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostBO postBO;

	public PostServlet() {
		super();
		postBO = new PostBO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String targetPage = "";

		// Query post by post id.
		Post post = postBO.findPostById(request.getParameter("id"));

		if (post != null) {

			// Populate post to request attribute for render on view.
			request.setAttribute("post", post);

			// Set target view is post detail page.
			targetPage = "/WEB-INF/pages/post-detail.jsp";
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
}
