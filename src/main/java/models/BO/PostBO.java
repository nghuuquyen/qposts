package models.BO;

import java.util.List;

import exceptions.DAOException;
import models.DAO.CategoryDAO;
import models.DAO.CategoryDAOImpl;
import models.DAO.PostDAO;
import models.DAO.PostDAOImpl;
import models.DTO.Category;
import models.DTO.Post;

public class PostBO {
	PostDAO postDAO;
	CategoryDAO categoryDAO;

	public PostBO() {
		postDAO = new PostDAOImpl();
		categoryDAO = new CategoryDAOImpl();
	}

	public List<Post> getAllPosts(int limit, int skip) {
		return postDAO.getAllPosts(limit, skip);
	}

	public Post findPostById(String id) {
		return postDAO.findPostById(id);
	}

	public boolean update(Post post) throws DAOException {
		return postDAO.update(post);
	}

	public Post create(Post p) throws DAOException {
		return postDAO.create(p);
	}

	public List<Category> getAllCategories(int limit, int skip) throws DAOException {
		return categoryDAO.getAll(limit, skip);
	}
}
