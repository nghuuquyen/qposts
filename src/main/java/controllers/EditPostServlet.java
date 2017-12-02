package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BO.PostBO;
import models.DTO.Post;

@WebServlet("/post/edit")
public class EditPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PostBO postBO;

	public EditPostServlet() {
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
		if (postBO.updatePost(p) != null) {
			request.setAttribute("message", "Update post successfully.");
		} else {
			request.setAttribute("message", "Has error when update post.");
		}

		// Create dispatcher for forward data for JSP file.
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/post-edit.jsp");
		
		// Forward all data to homepage.jsp file for process render view.
		rd.forward(request, response);
	}
}
