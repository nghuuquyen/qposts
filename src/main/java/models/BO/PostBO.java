package models.BO;

import java.util.List;

import models.DAO.PostDAO;
import models.DAO.PostDAOImpl;
import models.DTO.Post;

public class PostBO {
	PostDAO postDAO;

	public PostBO() {
		postDAO = new PostDAOImpl();
	}

	public List<Post> getAllPosts(int limit, int skip) {
		return postDAO.getAllPosts(limit, skip);
	}

	public Post findPostById(String id) {
		return postDAO.findPostById(id);
	}

	public Post updatePost(Post post) {
		return postDAO.updatePost(post);
	}
}
