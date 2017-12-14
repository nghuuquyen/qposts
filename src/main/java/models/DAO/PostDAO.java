package models.DAO;

import java.util.List;

import exceptions.DAOException;
import models.DTO.Post;

public interface PostDAO {
	public Post findPostById(String id);
	public List<Post> getAllPosts(int limit, int skip);
	public boolean remove(String id) throws DAOException;
	public boolean update(Post post) throws DAOException;
	public Post create(Post p) throws DAOException;
}
