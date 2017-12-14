package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.DAOException;
import models.BO.PostBO;
import models.DTO.Category;
import models.DTO.Post;
import models.utils.SessionManager;

@WebServlet("/post/create")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostBO postBO;

	public CreatePostServlet() {
		super();
		postBO = new PostBO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// -1 mean load all categories without limit.
			request.setAttribute("categories", postBO.getAllCategories(-1, 0));
		} catch (DAOException e) {
			request.setAttribute("error", e.getMessage());
		}

		request.getRequestDispatcher("/WEB-INF/pages/post-create.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Post p = new Post();

		// Must set encoding.
		request.setCharacterEncoding("UTF-8");

		p.setName(request.getParameter("pName"));
		p.setDescription(request.getParameter("pDescription"));
		p.setContent(request.getParameter("pContent"));
		p.setCategory(new Category(request.getParameter("cId")));
		
		// Validate CSRF token.
		if (SessionManager.validateCSRFToken(request)) {
			try {
				p = postBO.create(p);

				if (p != null) {
					request.setAttribute("post", p);
				} else {
					request.setAttribute("message", "Has error when create post.");
				}
			} catch (DAOException e) {
				request.setAttribute("message", e.getMessage());
			}
		} else {
			request.setAttribute("message", "CSRF token not valid.");
		}

		if (p != null && p.getId() != null) {
			response.sendRedirect(request.getContextPath() + "/post/edit?id=" + p.getId());
		} else {
			request.getRequestDispatcher("/WEB-INF/pages/post-create.jsp").forward(request, response);
		}
	}
}
