package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BO.PostBO;

public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostBO postBO;
	
	public HomepageServlet() {
		super();
		postBO = new PostBO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Query all departments at first page and limit 50 posts.
		request.setAttribute("posts", postBO.getAllPosts(50, 0));
		
		// 2. Create dispatcher for forward data for JSP file.
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/homepage.jsp");
		
		// 3. Forward all data to homepage.jsp file for process render view.
		rd.forward(request, response);
	}
}
