package models.BO;

import java.util.List;

import models.DAO.PostDAO;
import models.DTO.Post;

public class PostBO {
	PostDAO postDAO;
	
	public PostBO() {
		postDAO = new PostDAO();
	}
	
	public List<Post> getAllPosts(int limit, int skip) {
		return postDAO.getAllPosts(limit, skip);
	}
}
